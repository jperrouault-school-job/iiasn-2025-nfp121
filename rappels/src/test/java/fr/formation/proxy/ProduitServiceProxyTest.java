package fr.formation.proxy;

import java.lang.reflect.Field;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ProduitServiceProxyTest {
    @Test
    void shouldProxiedBecomeTrue() throws Exception {
        // given
        ProduitService service = new ProduitService();
        ProduitServiceProxy proxy = new ProduitServiceProxy(service);

        Field field = proxy.getClass().getDeclaredField("proxied");

        field.setAccessible(true);

        Assertions.assertFalse(field.getBoolean(proxy));
        
        // when
        proxy.findAll();
        
        // then
        Assertions.assertTrue(field.getBoolean(proxy));
    }
}
