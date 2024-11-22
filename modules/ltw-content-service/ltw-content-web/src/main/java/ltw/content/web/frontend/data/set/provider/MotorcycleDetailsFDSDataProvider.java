package ltw.content.web.frontend.data.set.provider;

import com.liferay.frontend.data.set.provider.FDSDataProvider;
import com.liferay.frontend.data.set.provider.search.FDSKeywords;
import com.liferay.frontend.data.set.provider.search.FDSPagination;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.search.Sort;
import ltw.content.service.model.LTW_content;
import ltw.content.service.service.LTW_contentLocalService;
import ltw.content.web.constants.MotorcycleFDSNames;
import ltw.content.web.model.Motorcycle;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Component(
 property = "fds.data.provider.key=" + MotorcycleFDSNames.Motocycle,
        service = FDSDataProvider.class
)
public class MotorcycleDetailsFDSDataProvider implements FDSDataProvider<Motorcycle> {
    @Override
    public List<Motorcycle> getItems(FDSKeywords fdsKeywords, FDSPagination fdsPagination, HttpServletRequest httpServletRequest, Sort sort) throws PortalException {
        List<Motorcycle> motorcycles = new ArrayList<>();

        List<LTW_content> contents = _ltwContentLocalService.getAllLTW_Contents();

        for(LTW_content content: contents) {
            motorcycles.add(
                    new Motorcycle(
                            content.getLtwId(),
                            content.getMotorcycleName(),
                            content.getMotorcycleManufacturing(),
                            content.getMotorcycleYear()
                    )
            );
        }

        return motorcycles;
    }

    @Override
    public int getItemsCount(FDSKeywords fdsKeywords, HttpServletRequest httpServletRequest) throws PortalException {
        return _ltwContentLocalService.getLTW_contentsCount();
    }

    @Reference
    private LTW_contentLocalService _ltwContentLocalService;
}


