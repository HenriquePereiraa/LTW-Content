package ltw.content.web.display;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.model.ListType;
import ltw.content.service.model.LTW_content;
import ltw.content.service.service.LTW_contentLocalServiceUtil;

public class LtwContentDisplay {
    public static LtwContentDisplay of(LTW_content ltwContent) {
        if(ltwContent != null) {
            return new LtwContentDisplay(ltwContent);
        }
        return _EMPTY_INSTANCE;
    }

    public static LtwContentDisplay of(long contentId) {
        return of(LTW_contentLocalServiceUtil.fetchLTW_content(contentId));
    }

    public long getContentId() {
        return _motorcycleId;
    }

    public String get_motorcycleManufacturing() {
        return _motorcycleManufacturing;
    }

    public String get_motorcycleName() {
        return _motorcycleName;
    }


    public int get_motorcycleYear() {
        return _motorcycleYear;
    }

    private LtwContentDisplay() {
        _motorcycleId = 0;
        _motorcycleName = StringPool.BLANK;
        _motorcycleYear = 0;
        _motorcycleManufacturing = StringPool.BLANK;
    }

    private LtwContentDisplay(LTW_content ltwContent) {
        _motorcycleId = ltwContent.getLtwId();
        _motorcycleName = ltwContent.getMotorcycleName();
        _motorcycleManufacturing = ltwContent.getMotorcycleManufacturing();
        _motorcycleYear = ltwContent.getMotorcycleYear();
    }

    private static final LtwContentDisplay _EMPTY_INSTANCE = new LtwContentDisplay();

    private final long _motorcycleId;
    private final String _motorcycleName;
    private final String _motorcycleManufacturing;
    private final int _motorcycleYear;
}
