package fr.formation;

public class Factory {
    private Factory() { }

    public static ProduitRepository createProduitRepository() {
        return new ProduitRepository();
    }

    public static ProduitService createProduitService() {
        // Injection de dépendance par constructeur .. Le ProduitService a besoin d'un ProduitRepository
        // return new ProduitService(createProduitRepository());
        return new ProduitService();
    }

    public static ProduitController createProduitController() {
        ProduitController ctrl = new ProduitController();

        // Injection de dépendance par setter .. Le ProduitController a besoin d'un ProduitService
        ctrl.setProduitService(createProduitService());

        return ctrl;
    }
}
