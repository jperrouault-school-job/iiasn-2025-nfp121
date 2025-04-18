package fr.formation.proxy;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ProduitServiceProxy extends ProduitService {
    private final ProduitService service;

    private boolean proxied = false;

    // public ProduitServiceProxy(ProduitService service) {
    //     this.service = service;
    // }

    @Override
    public void findAll() {
        System.out.println("PROXY !");

        if (!proxied) {
            proxied = true;
            service.findAll();
        }
    }
}
