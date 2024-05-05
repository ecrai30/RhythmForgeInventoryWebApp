package com.example.demo.bootstrap;

import com.example.demo.domain.OutsourcedPart;
import com.example.demo.domain.InhousePart;//change
import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.repositories.OutsourcedPartRepository;
import com.example.demo.repositories.InhousePartRepository;//change
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.service.OutsourcedPartService;
import com.example.demo.service.OutsourcedPartServiceImpl;
import com.example.demo.service.InhousePartService;//change
import com.example.demo.service.InhousePartServiceImpl;//change
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 *
 *
 *
 *
 */
@Component
public class BootStrapData implements CommandLineRunner {

    private final PartRepository partRepository;
    private final ProductRepository productRepository;

    private final OutsourcedPartRepository outsourcedPartRepository;



    public BootStrapData(PartRepository partRepository, ProductRepository productRepository, OutsourcedPartRepository outsourcedPartRepository) {
        this.partRepository = partRepository;
        this.productRepository = productRepository;
        this.outsourcedPartRepository=outsourcedPartRepository;


    }

    @Override
    public void run(String... args) throws Exception {
        if (productRepository.count() == 0 && partRepository.count() == 0 && outsourcedPartRepository.count() == 0) {
            // Add Parts Required to build products
            OutsourcedPart ds1= new OutsourcedPart();
            ds1.setCompanyName("Rhythm Forge");
            ds1.setName("10-inch Tom");
            ds1.setInv(100);
            ds1.setPrice(100.00);
            ds1.setId(100L);
            ds1.setMin_inv(0);
            ds1.setMax_inv(1000);
            outsourcedPartRepository.save(ds1);
            OutsourcedPart thePart1=null;
            List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
            for(OutsourcedPart part:outsourcedParts){
                if(part.getName().equals("10-inch Tom"))thePart1=part;
            }

            System.out.println(thePart1.getCompanyName());

            OutsourcedPart ds2= new OutsourcedPart();
            ds2.setCompanyName("Rhythm Forge");
            ds2.setName("12-inch Tom");
            ds2.setInv(100);
            ds2.setPrice(200.00);
            ds2.setId(200L);
            ds2.setMin_inv(0);
            ds2.setMax_inv(1000);
            outsourcedPartRepository.save(ds2);
            OutsourcedPart thePart2=null;
            List<OutsourcedPart> outsourcedParts2=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
            for(OutsourcedPart part:outsourcedParts2){
                if(part.getName().equals("12-inch Tom"))thePart2=part;
            }

            System.out.println(thePart2.getCompanyName());

            OutsourcedPart ds3= new OutsourcedPart();
            ds3.setCompanyName("Rhythm Forge");
            ds3.setName("14-inch Tom");
            ds3.setInv(100);
            ds3.setPrice(300.00);
            ds3.setId(300L);
            ds3.setMin_inv(0);
            ds3.setMax_inv(1000);
            outsourcedPartRepository.save(ds3);
            OutsourcedPart thePart3=null;
            List<OutsourcedPart> outsourcedParts3=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
            for(OutsourcedPart part:outsourcedParts3){
                if(part.getName().equals("14-inch Tom"))thePart3=part;
            }

            System.out.println(thePart3.getCompanyName());


            OutsourcedPart ds4= new OutsourcedPart();
            ds4.setCompanyName("Rhythm Forge");
            ds4.setName("Bass Drum");
            ds4.setInv(100);
            ds4.setPrice(500.00);
            ds4.setId(400L);
            ds4.setMin_inv(0);
            ds4.setMax_inv(1000);
            outsourcedPartRepository.save(ds4);
            OutsourcedPart thePart4=null;
            List<OutsourcedPart> outsourcedParts4=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
            for(OutsourcedPart part:outsourcedParts4){
                if(part.getName().equals("Bass Drum"))thePart4=part;
            }

            System.out.println(thePart4.getCompanyName());

            OutsourcedPart ds5= new OutsourcedPart();
            ds5.setCompanyName("Rhythm Forge");
            ds5.setName("Hi-hat");
            ds5.setInv(100);
            ds5.setPrice(150.00);
            ds5.setId(500L);
            ds5.setMin_inv(0);
            ds5.setMax_inv(1000);
            outsourcedPartRepository.save(ds5);
            OutsourcedPart thePart5=null;
            List<OutsourcedPart> outsourcedParts5=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
            for(OutsourcedPart part:outsourcedParts5){
                if(part.getName().equals("Hi-hat"))thePart5=part;
            }
            System.out.println(thePart5.getCompanyName());

            //Snare drum
            OutsourcedPart ds6= new OutsourcedPart();
            ds6.setCompanyName("Rhythm Forge");
            ds6.setName("Snare");
            ds6.setInv(60);
            ds6.setPrice(400.00);
            ds6.setId(600L);
            ds6.setMin_inv(0);
            ds6.setMax_inv(1000);
            outsourcedPartRepository.save(ds6);
            OutsourcedPart thePart6=null;
            List<OutsourcedPart> outsourcedParts6=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
            for(OutsourcedPart part:outsourcedParts6){
                if(part.getName().equals("Snare"))thePart6=part;
            }

            System.out.println(thePart6.getCompanyName());


            //Crash Cymbal
            OutsourcedPart ds7= new OutsourcedPart();
            ds7.setCompanyName("Rhythm Forge");
            ds7.setName("Crash Cymbal");
            ds7.setInv(100);
            ds7.setPrice(200.00);
            ds7.setId(700L);
            ds7.setMin_inv(0);
            ds7.setMax_inv(1000);
            outsourcedPartRepository.save(ds7);
            OutsourcedPart thePart7=null;
            List<OutsourcedPart> outsourcedParts7=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
            for(OutsourcedPart part:outsourcedParts7){
                if(part.getName().equals("Crash Cymbal"))thePart7=part;
            }

            System.out.println(thePart7.getCompanyName());


            //Ride Cymbal
            OutsourcedPart ds8= new OutsourcedPart();
            ds8.setCompanyName("Rhythm Forge");
            ds8.setName("Ride Cymbal");
            ds8.setInv(100);
            ds8.setPrice(450.00);
            ds8.setId(800L);
            ds8.setMin_inv(0);
            ds8.setMax_inv(1000);
            outsourcedPartRepository.save(ds8);
            OutsourcedPart thePart8=null;
            List<OutsourcedPart> outsourcedParts8=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
            for(OutsourcedPart part:outsourcedParts8){
                if(part.getName().equals("Crash Cymbal"))thePart8=part;
            }
            System.out.println(thePart8.getCompanyName());

            //Splash Cymbal
            OutsourcedPart ds9= new OutsourcedPart();
            ds9.setCompanyName("Rhythm Forge");
            ds9.setName("Splash Cymbal");
            ds9.setInv(100);
            ds9.setPrice(200.00);
            ds9.setId(900L);
            ds9.setMin_inv(0);
            ds9.setMax_inv(1000);
            outsourcedPartRepository.save(ds9);
            OutsourcedPart thePart9=null;
            List<OutsourcedPart> outsourcedParts9=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
            for(OutsourcedPart part:outsourcedParts9){
                if(part.getName().equals("Splash Cymbal"))thePart9=part;
            }
            System.out.println(thePart9.getCompanyName());

            // Drum Mount Rack
            OutsourcedPart ds10= new OutsourcedPart();
            ds10.setCompanyName("Rhythm Forge");
            ds10.setName("Drum Rack");
            ds10.setInv(100);
            ds10.setPrice(800.00);
            ds10.setId(1000L);
            ds10.setMin_inv(0);
            ds10.setMax_inv(1000);
            outsourcedPartRepository.save(ds10);
            OutsourcedPart thePart10=null;
            List<OutsourcedPart> outsourcedParts10=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
            for(OutsourcedPart part:outsourcedParts10){
                if(part.getName().equals("Drum Rack"))thePart10=part;
            }

            System.out.println(thePart10.getCompanyName());





            // Add sample products
            Product drumSet1 = new Product("Velocity Pro Drum Set", 1890.00, 100);
            Product drumSet2 = new Product("Rhythm King Drum Set", 1300.00, 100);
            Product drumSet3 = new Product("Mystic Groove Drum Set", 770.00, 60);
            Product drumSet4 = new Product("Nova Beats Drum Set", 1249.00, 100);
            Product drumSet5 = new Product("Eclipse Fusion Drum Set", 990.00, 70);
            Product throne = new Product("Drum Throne", 350.00, 100);
            Product pedal = new Product("Drum Pedal", 100.00, 100);
            Product drumSticks = new Product("Drum Sticks", 80.00, 200);


            productRepository.saveAll(List.of(drumSet1, drumSet2, drumSet3, drumSet4, drumSet5, throne, pedal, drumSticks));
        }
       /*
        OutsourcedPart o= new OutsourcedPart();
        o.setCompanyName("Western Governors University");
        o.setName("out test");
        o.setInv(5);
        o.setPrice(20.0);
        o.setId(100L);
        outsourcedPartRepository.save(o);
        OutsourcedPart thePart=null;
        List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for(OutsourcedPart part:outsourcedParts){
            if(part.getName().equals("out test"))thePart=part;
        }

        System.out.println(thePart.getCompanyName());
        */
        List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for(OutsourcedPart part:outsourcedParts){
            System.out.println(part.getName()+" "+part.getCompanyName());
        }

        /*
        Product bicycle= new Product("bicycle",100.0,15);
        Product unicycle= new Product("unicycle",100.0,15);
        productRepository.save(bicycle);
        productRepository.save(unicycle);
        */

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Products"+productRepository.count());
        System.out.println(productRepository.findAll());
        System.out.println("Number of Parts"+partRepository.count());
        System.out.println(partRepository.findAll());

    }
}
