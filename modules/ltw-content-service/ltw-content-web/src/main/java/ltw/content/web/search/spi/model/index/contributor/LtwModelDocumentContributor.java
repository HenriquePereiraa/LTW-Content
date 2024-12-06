package ltw.content.web.search.spi.model.index.contributor;

import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.search.spi.model.index.contributor.ModelDocumentContributor;
import ltw.content.service.model.LTW_content;
import org.osgi.service.component.annotations.Component;

/**
 * @author Henrique Pereira
 */

@Component(
        properties = "indexer.class.name=ltw.content.service.model.LTW_content",
        service = ModelDocumentContributor.class
)

public class LtwModelDocumentContributor
        implements ModelDocumentContributor<LTW_content> {

    @Override
    public void contribute(Document document, LTW_content ltwContent) {
        document.addText(Field.NAME, ltwContent.getUserName());
        document.addText("motorcycleName", ltwContent.getMotorcycleName());
        document.addText("motorcycleManufacturing", ltwContent.getMotorcycleManufacturing());
        document.addNumber("motorcycleYear", ltwContent.getMotorcycleYear());
    }

    private String _getMotorcycleName(LTW_content ltwContent) {
        return ltwContent.getMotorcycleName();
    }

    private String _getMotorcycleManufacturing(LTW_content ltwContent) {
        return ltwContent.getMotorcycleManufacturing();
    }

    private int _getMotorcycleYear(LTW_content ltwContent) {
        return ltwContent.getMotorcycleYear();
    }
}
