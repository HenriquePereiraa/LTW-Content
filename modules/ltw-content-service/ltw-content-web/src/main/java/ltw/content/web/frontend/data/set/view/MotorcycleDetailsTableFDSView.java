package ltw.content.web.frontend.data.set.view;


import com.liferay.frontend.data.set.view.FDSView;
import com.liferay.frontend.data.set.view.table.BaseTableFDSView;
import com.liferay.frontend.data.set.view.table.FDSTableSchema;
import com.liferay.frontend.data.set.view.table.FDSTableSchemaBuilder;
import com.liferay.frontend.data.set.view.table.FDSTableSchemaBuilderFactory;
import ltw.content.web.constants.MotorcycleFDSNames;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.Locale;

@Component(
        property = "frontend.data.set.name=" + MotorcycleFDSNames.Motocycle,
        service = FDSView.class
)
public class MotorcycleDetailsTableFDSView extends BaseTableFDSView {
    @Override
    public FDSTableSchema getFDSTableSchema(Locale locale) {
        FDSTableSchemaBuilder fdsTableSchemaBuilder = _fdsTableSchemaBuilderFactory.create();

        return fdsTableSchemaBuilder.add(
                "motorcycleName", "Motorcycle Name"
        ).add(
                "motorcycleManufacturing", "Motorcycle Manufacturing"
        ).add(
                "motorcycleYear", "Motorcycle Year"
        ).build();
    }

    @Reference
    private FDSTableSchemaBuilderFactory _fdsTableSchemaBuilderFactory;
}
