package openmarker.tea.compiler;

/**
 * This has been moved to {@link openmarker.trove.util.StatusEvent}
 *
 * @deprecated
 */
@Deprecated
public class StatusEvent extends openmarker.trove.util.StatusEvent {

    private static final long serialVersionUID = 1L;

    public StatusEvent(Object source, int current, int total, String currentName) {
        super(source, current, total, currentName);
    }

}
