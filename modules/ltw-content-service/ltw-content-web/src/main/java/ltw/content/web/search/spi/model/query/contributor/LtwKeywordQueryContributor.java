package ltw.content.web.search.spi.model.query.contributor;

import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.search.query.QueryHelper;
import com.liferay.portal.search.spi.model.query.contributor.KeywordQueryContributor;
import com.liferay.portal.search.spi.model.query.contributor.helper.KeywordQueryContributorHelper;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
* @author Henrique Pereira
*/

@Component(
        property = "indexer.class=name=ltw.content.service.model.LTW_content",
        service = KeywordQueryContributor.class
)
public class LtwKeywordQueryContributor implements KeywordQueryContributor {

    @Override
    public void contribute(
            String keywords, BooleanQuery booleanQuery,
            KeywordQueryContributorHelper keywordQueryContributorHelper) {

        queryHelper.addSearchTerm(
                booleanQuery, keywordQueryContributorHelper.getSearchContext(),
                Field.NAME, false
        );
        queryHelper.addSearchTerm(
                booleanQuery, keywordQueryContributorHelper.getSearchContext(),
                "motorcycleName", false
        );
        queryHelper.addSearchTerm(
                booleanQuery, keywordQueryContributorHelper.getSearchContext(),
                "motorcycleManufacturing", false
        );
        queryHelper.addSearchTerm(
                booleanQuery, keywordQueryContributorHelper.getSearchContext(),
                "motorcycleYear", false
        );
    }

    @Reference
    protected QueryHelper queryHelper;
}
