package ltw.content.web.search.spi.model.query.contributor;

import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.filter.BooleanFilter;
import com.liferay.portal.search.spi.model.query.contributor.ModelPreFilterContributor;
import com.liferay.portal.search.spi.model.registrar.ModelSearchSettings;
import org.osgi.service.component.annotations.Component;

/**
 * @author Henrique Pereira
 * */

@Component(
        property="indexer.class.name=ltw.content.service.model.LTW_content",
        service= ModelPreFilterContributor.class
)
public class LwtModelPreFilterContributor
        implements ModelPreFilterContributor {
    @Override
    public void contribute(
            BooleanFilter booleanFilter, ModelSearchSettings modelSearchSettings,
            SearchContext searchContext) {

    }
}
