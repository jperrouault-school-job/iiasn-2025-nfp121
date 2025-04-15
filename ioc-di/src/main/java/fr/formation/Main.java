package fr.formation;

public class Main {
    public static void main(String[] args) {
        // ProduitController ctrl = Factory.createProduitController();
        ProduitRepository repository = BeanFactory.createBean(ProduitRepository.class);
        ProduitService service = BeanFactory.createBean(ProduitService.class);
        ProduitController ctrl = BeanFactory.createBean(ProduitController.class);

        service.setProduitRepository(repository);
        ctrl.setProduitService(service);

        System.out.println(ctrl.findAll());
    }
}
