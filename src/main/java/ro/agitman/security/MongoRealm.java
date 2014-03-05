package ro.agitman.security;

import java.util.HashSet;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;

import ro.agitman.model.MongoProvider;
import ro.agitman.model.mo.Role;
import ro.agitman.model.mo.User;

import com.google.inject.Inject;

public class MongoRealm extends AuthorizingRealm {

	@Inject
	private MongoProvider mongoProvider;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection pc) {
		Datastore ds = mongoProvider.get();

		Set<String> roles = new HashSet<>();
		Set<Permission> permissions = new HashSet<>();
		for (Object tmp : pc.fromRealm(getClass().getName())) {
			User user = ds.find(User.class).field("name").equal(tmp.toString()).get();
			if (user != null) {
				roles.addAll(user.getRoles());
				for (String temp : roles) {
					Query<Role> q = ds.createQuery(Role.class);
					q.field("name").equal(temp);
					Role role = q.get();
					if (role != null) {
						permissions.addAll(role.getPermissions());
					}
				}
			}
		}
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		info.setRoles(roles);
		info.setObjectPermissions(permissions);
		return info;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken at) throws AuthenticationException {
		Datastore ds = mongoProvider.get();
		User user = ds.find(User.class).field("name").equal(at.getPrincipal().toString()).get();

		if (user != null) {
			if (user.getPassword().equals(new String((char[]) at.getCredentials()))) {
				return new SimpleAuthenticationInfo(user.getName(), user.getPassword(), getClass().getName());
			}
		}
		throw new AuthenticationException();
	}

}
