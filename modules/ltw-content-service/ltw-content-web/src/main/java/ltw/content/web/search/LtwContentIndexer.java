package ltw.content.web.search;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.*;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ListUtil;

import com.liferay.portal.kernel.util.StringBundler;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;

import ltw.content.service.model.LTW_content;
import ltw.content.service.service.LTW_contentLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Henrique Pereira
 */
@Component(service = Indexer.class)
public class LtwContentIndexer extends BaseIndexer<LTW_content> {

    @Override
    protected void doDelete(LTW_content ltwContent) throws Exception {
        deleteDocument(
                ltwContent.getCompanyId(),
                ltwContent.getLtwId());
    }

    @Override
    protected Document doGetDocument(LTW_content ltwContent) throws Exception {
        Document document =
                getBaseModelDocument(
                        LTW_content.class.getName(), ltwContent);

        document.addKeyword(
                Field.CLASS_PK, ltwContent.getLtwId());
        document.addText(
                Field.NAME, ltwContent.getMotorcycleName());
        document.addKeyword(
                "ltwContentIds", _getLtwAllLtwContents());
        document.addKeyword(
                "userId", ltwContent.getUserId());
        document.addKeyword(
                "manufacturing", ltwContent.getMotorcycleManufacturing());
        document.addKeyword(
                "motocycle", ltwContent.getMotorcycleName());
        document.addKeyword(
                "year", ltwContent.getMotorcycleYear());

        return document;
    }

    @Override
    protected Summary doGetSummary(
            Document document, Locale locale, String s,
            PortletRequest portletRequest, PortletResponse portletResponse)
            throws Exception {

        Summary summary = createSummary(
                document, Field.ENTRY_CLASS_PK, Field.NAME);

        summary.setMaxContentLength(200);

        return summary;

    }

    @Override
    protected void doReindex(String className, long classPK) throws Exception {
        doReindex(_ltwContentLocalService.fetchLTW_content(classPK));
    }

    @Override
    protected void doReindex(String[] strings) throws Exception {
        long companyId = GetterUtil.getLong(strings[0]);

        _reindexLtwContent(companyId);
    }

    @Override
    protected void doReindex(LTW_content ltwContent) throws Exception {
        Collection<Document> documentCollection = new ArrayList<>();

        documentCollection.add(getDocument(ltwContent));

        _indexWriterHelper.updateDocuments(
                ltwContent.getLtwId(),
                documentCollection, isCommitImmediately());
    }

    @Override
    public String getClassName() {
        return LTW_content.class.getName();
    }

    private long[] _getLtwAllLtwContents(){
        return ListUtil.toLongArray(
                _ltwContentLocalService.getLTW_contents(QueryUtil.ALL_POS, 20),
                LTW_content::getLtwId
        );
    }

    private void _reindexLtwContent(long companyId) throws PortalException {
        IndexableActionableDynamicQuery indexableActionableDynamicQuery =
                _ltwContentLocalService.getIndexableActionableDynamicQuery();

        indexableActionableDynamicQuery.setCompanyId(companyId);
        indexableActionableDynamicQuery.setPerformActionMethod(
                (LTW_content ltwContent) -> {
                    if (_log.isDebugEnabled()) {
                        _log.debug(StringBundler.concat("Indexing LtwContent",
                                StringPool.SPACE, ltwContent.getUserName()));
                    }

                    indexableActionableDynamicQuery.addDocuments(
                            getDocument(ltwContent));
                });

        indexableActionableDynamicQuery.performActions();
    }

    private static final Log _log = LogFactoryUtil.getLog(LtwContentIndexer.class);

    @Reference
    private LTW_contentLocalService _ltwContentLocalService;

    @Reference
    private IndexWriterHelper _indexWriterHelper;

}
