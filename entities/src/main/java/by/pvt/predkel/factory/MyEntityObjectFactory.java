package by.pvt.predkel.factory;

import by.pvt.predkel.entities.*;
import by.pvt.predkel.entities.methodologicalOptions.CommonParameters;
import by.pvt.predkel.entities.methodologicalOptions.DetermineTheTypeOfFire;
import by.pvt.predkel.entities.methodologicalOptions.IntegratedThermalAndTechnicalParameters;
import by.pvt.predkel.entities.methodologicalOptions.ParametersCalculatedFireLoad;
import by.pvt.predkel.entities.temperatureSettings.ChangeInMeanBulkTemperature;
import by.pvt.predkel.entities.temperatureSettings.ChangeInTemperatureOfSlab;
import by.pvt.predkel.entities.temperatureSettings.ChangeInTemperatureOfWalls;

/**
 * This object contains factory methods for each
 * Java content interface and Java element interface
 * generated in the by.it.generate package.
 * <p>An MyEntityObjectFactory allows you to programatically
 * construct new instances of the Java representation
 * for XML content. The Java representation of XML
 * content can consist of schema derived interfaces
 * and classes representing the binding of schema
 * type definitions, element declarations and model
 * groups.  Factory methods for each of these are
 * provided in this class.
 */

public class MyEntityObjectFactory {


    /**
     * Create a new MyEntityObjectFactory that can be used to create new instances of schema derived classes for package: by.it.generate
     */
    public MyEntityObjectFactory() {
    }

    /**
     * Create an instance of {@link User }
     */
    public User createUser() {
        return new User();
    }

    /**
     * Create an instance of {@link Building }
     */
    public Building createBuilding() {
        return new Building();
    }

    /**
     * Create an instance of {@link CoefficientSForRoom }
     */
//    public CoefficientSForRoom createCoefficientSForRoom() {
//        return new CoefficientSForRoom();
//    }

    /**
     * Create an instance of {@link FlammableSubstance }
     */
    public FlammableSubstance createFlammableSubstance() {
        return new FlammableSubstance();
    }

    /**
     * Create an instance of {@link CommonParameters }
     */
    public CommonParameters createCommonParameters() {
        return new CommonParameters();
    }

    /**
     * Create an instance of {@link DetermineTheTypeOfFire }
     */
    public DetermineTheTypeOfFire createDetermineTheTypeOfFire() {
        return new DetermineTheTypeOfFire();
    }

    /**
     * Create an instance of {@link Aperture }
     */
    public Aperture createAperture() {
        return new Aperture();
    }

    /**
     * Create an instance of {@link SubstanceOfRoom }
     */
    public SubstanceOfRoom createSubstanceOfRoom() {
        return new SubstanceOfRoom();
    }

//    /**
//     * Create an instance of {@link CoefficientSForBuild }
//     */
//    public CoefficientSForBuild createCoefficientSForBuild() {
//        return new CoefficientSForBuild();
//    }

    /**
     * Create an instance of {@link ChangeInTemperatureOfSlab }
     */
    public ChangeInTemperatureOfSlab createChangeInTemperatureOfSlab() {
        return new ChangeInTemperatureOfSlab();
    }

    /**
     * Create an instance of {@link ChangeInMeanBulkTemperature }
     */
    public ChangeInMeanBulkTemperature createChangeInMeanBulkTemperature() {
        return new ChangeInMeanBulkTemperature();
    }

    /**
     * Create an instance of {@link ChangeInTemperatureOfWalls }
     */
    public ChangeInTemperatureOfWalls createChangeInTemperatureOfWalls() {
        return new ChangeInTemperatureOfWalls();
    }

    /**
     * Create an instance of {@link Room }
     */
    public Room createRoom() {
        return new Room();
    }

    /**
     * Create an instance of {@link IntegratedThermalAndTechnicalParameters }
     */
    public IntegratedThermalAndTechnicalParameters createIntegratedThermalAndTechnicalParameters() {
        return new IntegratedThermalAndTechnicalParameters();
    }

    /**
     * Create an instance of {@link ParametersCalculatedFireLoad }
     */
    public ParametersCalculatedFireLoad createParametersCalculatedFireLoad() {
        return new ParametersCalculatedFireLoad();
    }

}
