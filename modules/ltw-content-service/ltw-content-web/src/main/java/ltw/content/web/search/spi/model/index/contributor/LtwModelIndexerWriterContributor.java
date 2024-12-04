package ltw.content.web.search.spi.model.index.contributor;

import com.liferay.portal.search.batch.BatchIndexingActionable;
import com.liferay.portal.search.batch.DynamicQueryBatchIndexingActionableFactory;
import com.liferay.portal.search.spi.model.index.contributor.ModelIndexerWriterContributor;
import com.liferay.portal.search.spi.model.index.contributor.helper.ModelIndexerWriterDocumentHelper;
import ltw.content.service.model.LTW_content;
import ltw.content.service.service.LTW_contentLocalService;

public class LtwModelIndexerWriterContributor
        implements ModelIndexerWriterContributor<LTW_content> {

    public LtwModelIndexerWriterContributor(
            LTW_contentLocalService ltwContentLocalService,
            DynamicQueryBatchIndexingActionableFactory dynamicQueryBatchIndexingActionableFactory
    ) {
       _ltwContentLocalService = ltwContentLocalService;
        _dynamicQueryBatchIndexingActionableFactory = dynamicQueryBatchIndexingActionableFactory;
    }

    @Override
    public void customize(
            BatchIndexingActionable batchIndexingActionable,
            ModelIndexerWriterDocumentHelper modelIndexerWriterDocumentHelper) {

        batchIndexingActionable.setPerformActionMethod
                ((LTW_content ltwContent) -> batchIndexingActionable.addDocuments(
                        modelIndexerWriterDocumentHelper.getDocument(ltwContent))
        );
    }

    @Override
    public BatchIndexingActionable getBatchIndexingActionable() {
        return _dynamicQueryBatchIndexingActionableFactory.getBatchIndexingActionable(
                _ltwContentLocalService.getIndexableActionableDynamicQuery()
        );
    }

    @Override
    public long getCompanyId(LTW_content ltwContent) {
        return ltwContent.getCompanyId();
    }

    private final LTW_contentLocalService _ltwContentLocalService;
    private final DynamicQueryBatchIndexingActionableFactory _dynamicQueryBatchIndexingActionableFactory;
}
