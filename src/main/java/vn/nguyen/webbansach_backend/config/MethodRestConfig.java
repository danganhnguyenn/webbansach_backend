package vn.nguyen.webbansach_backend.config;

import jakarta.persistence.EntityManager;
import jakarta.persistence.metamodel.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import vn.nguyen.webbansach_backend.entity.NguoiDung;
import vn.nguyen.webbansach_backend.entity.TheLoai;

@Configuration
public class MethodRestConfig implements RepositoryRestConfigurer {
    private String url = "http://localhost:8080";

    @Autowired
    private EntityManager entityManager;

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        HttpMethod[] chanCacPhuongThuc = {
                HttpMethod.POST,
                HttpMethod.PUT,
                HttpMethod.PATCH,
                HttpMethod.DELETE
        };

        // expose ids
        // cho phép id trong khi tra ve json
         config.exposeIdsFor(entityManager
                 .getMetamodel()
                 .getEntities()
                 .stream()
                 .map(Type::getJavaType)
                 .toArray(Class[]::new));
        // config.exposeIdsFor(TheLoai.class);

        disableHttpMethods(TheLoai.class, config, chanCacPhuongThuc);
        disableHttpMethods(NguoiDung.class, config, new HttpMethod[] {HttpMethod.DELETE} );
    }

    private void disableHttpMethods(Class c,
                                 RepositoryRestConfiguration config,
                                 HttpMethod[] methods) {
                config.getExposureConfiguration()
                .forDomainType(c)
                .withItemExposure((metdata, httpMethods) -> httpMethods.disable(methods))
                .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(methods));
    }
}
