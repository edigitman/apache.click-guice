package ro.agitman.page;

import com.google.inject.Inject;
import org.apache.click.ActionResult;
import org.apache.click.Control;
import org.apache.click.ajax.DefaultAjaxBehavior;
import org.apache.click.control.ActionLink;
import ro.agitman.service.UserService;

/**
 * Created by AlexandruG on 11/3/2014.
 */
public class IndexPage extends BorderPage{

    @Inject
    private UserService userService;

    public String title = "Home";
    private ActionLink link = new ActionLink("link", "here");

    public IndexPage() {
        link.setId("link-id");

        addControl(link);

        link.addBehavior(new DefaultAjaxBehavior() {

            @Override
            public ActionResult onAction(Control source) {
                // Formatted date instance that will be added to the
                String now = format.currentDate("MMM, yyyy dd HH:MM:ss");

                String msg =
                        "AjaxBehavior <tt>onAction()</tt> method invoked by <u>" + userService.getName() + "</u> at: "
                                + now;
                // Return an action result containing the message
                return new ActionResult(msg, ActionResult.HTML);
            }
        });
    }
}
