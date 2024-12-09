package ltw.content.web.search;

import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.search.batch.DynamicQueryBatchIndexingActionableFactory;
import com.liferay.portal.search.spi.model.index.contributor.ModelIndexerWriterContributor;
import com.liferay.portal.search.spi.model.registrar.ModelSearchConfigurator;
import ltw.content.service.model.LTW_content;
import ltw.content.service.service.LTW_contentLocalService;
import ltw.content.web.search.spi.model.index.contributor.LtwModelIndexerWriterContributor;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Henrique Pereira
 * */

@Component(
        service = ModelSearchConfigurator.class
)
public class LtwModelSearchConfigurator
        implements ModelSearchConfigurator<LTW_content> {

    @Override
    public String getClassName() {
        return LTW_content.class.getName();
    }

    @Override
    public String[] getDefaultSelectedFieldNames() {
        return new String[] {
                Field.COMPANY_ID, Field.ENTRY_CLASS_NAME, Field.ENTRY_CLASS_PK,
                Field.MODIFIED_DATE, Field.NAME, Field.TYPE, Field.UID
        };
    }

    @Override
    public ModelIndexerWriterContributor<LTW_content> getModelIndexerWriterContributor() {
        return _modelIndexerWriterContributor;
    }

    @Activate
    protected void activate() {
        _modelIndexerWriterContributor = new LtwModelIndexerWriterContributor(
                _ltwContentLocalService, _dynamicQueryBatchIndexingActionableFactory
        );
    }

    @Reference
    private LTW_contentLocalService _ltwContentLocalService;

    @Reference
    private DynamicQueryBatchIndexingActionableFactory _dynamicQueryBatchIndexingActionableFactory;

    private ModelIndexerWriterContributor<LTW_content> _modelIndexerWriterContributor;
}
