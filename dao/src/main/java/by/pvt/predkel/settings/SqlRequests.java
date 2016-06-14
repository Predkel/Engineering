package by.pvt.predkel.settings;

public class SqlRequests {
    //public static final String REQUESTS_BUNDLE = "requests";

//	///////////User\\\\\\\\\\\\\
//	public static final String SQL_QUERY_GET_USERS = "SELECT * FROM `users` ";
//	public static final String SQL_QUERY_DELETE_USER = "DELETE FROM `users` WHERE `id.user` = '%d';";
//	public static final String SQL_QUERY_UPDATE_USER = "UPDATE `users` SET `Login` = '%s', `Password` = '%s', `Email` = '%s', `admin`='%s' WHERE `id.user` = %d;";
//	public static final String SQL_QUERY_CREATE_USER = "insert INTO `users`(`Login`,`Password`,`Email`,`Admin`)" +
//			" values('%s','%s','%s','%s');";

    ///////////newUser\\\\\\\\\\\\\
    public static final String GET_USERS = "SELECT * FROM `users` ";
    public static final String DELETE_USER = "DELETE FROM `users` WHERE `id.user` = ?;";
    public static final String UPDATE_USER = "UPDATE `users` SET `login` = ?, `password` = ?, `admin`=? WHERE `id.user` = ?;";
    public static final String CREATE_USER = "insert INTO `users`(`Login`,`Password`,`Admin`)" +
            " values(?,?,?);";
    public static final String GET_USER_BY_ID = "SELECT * FROM `users` WHERE `id.user` = ?;";
    public static final String GET_USER_BY_LOGIN = "SELECT * FROM `users` WHERE `login` = ?;";
    public static final String CHECK_AUTHORIZATION = "SELECT * FROM `users` WHERE `login` = ? AND `password` = ?;";


//	//////////////Building\\\\\\\\\\
//	public static final String SQL_QUERY_GET_BUILDINGS = "SELECT * FROM `building` ";
//	public static final String SQL_QUERY_DELETE_BUILDING = "DELETE FROM `building` WHERE `id.building` = %d;";
//	public static final String SQL_QUERY_UPDATE_BUILDING = "UPDATE `building` SET `fk.id.user` = '%s', `nameOfBuilding` = '%s', `selectedTemperatureOfRegion` = '%s', " +
//			"`specifyingCoefficientS5`='%s', `dateOfBuilding`='%s' WHERE `id.building` = %d;";
//	public static final String SQL_QUERY_CREATE_BUILDING = "insert INTO building(`fk.id.user`,`nameOfBuilding`,`selectedTemperatureOfRegion`," +
//			"`specifyingCoefficientS5`,`dateOfBuilding`) values('%s','%s','%s','%s','%s');";

    //////////////newBuilding\\\\\\\\\\
    public static final String GET_BUILDINGS = "SELECT * FROM `building` ";
    public static final String DELETE_BUILDING = "DELETE FROM `building` WHERE `id.building` = ?;";
    public static final String UPDATE_BUILDING = "UPDATE `building` SET `fk.id.user` = ?, `nameOfBuilding` = ?, `selectedTemperatureOfRegion` = ?, " +
            "`specifyingCoefficientS5`=?, `dateOfBuilding`=? WHERE `id.building` = ?;";
    public static final String CREATE_BUILDING = "insert INTO building(`fk.id.user`,`nameOfBuilding`,`selectedTemperatureOfRegion`," +
            "`specifyingCoefficientS5`,`dateOfBuilding`) values(?,?,?,?,?);";
    public static final String GET_BUILDING_BY_ID = "SELECT * FROM `building` WHERE `id.building` = ?;";
    public static final String GET_BUILDING_BY_FK_USER = "SELECT * FROM `building` WHERE `fk.id.user` = ?;";
    public static final String BUILDING_CREATED_EARLY = "SELECT * FROM `building` WHERE `nameOfBuilding` = ? " +
            "AND `fk.id.user` = ?;";

//	/////////////Room\\\\\\\\\\\\\\
//	public static final String SQL_QUERY_GET_ROOMS = "SELECT * FROM `room` ";
//	public static final String SQL_QUERY_DELETE_ROOM = "DELETE FROM `room` WHERE `id.room` = '%d';";
//	public static final String SQL_QUERY_UPDATE_ROOM = "UPDATE `room` SET `positionOfRoom`='%s', `nameOfRoom`='%s', `square`='%s'," +
//			" `height`='%s', `perimeter`='%s', `volume`='%s', `squareOfConstruction`='%s', `specificFireLoad`='%s'," +
//			" `reducedHeightOfApertures`='%s', `generalSquareOfApertures`='%s', `ventilationParameter`='%s'," +
//			" `coefficientK`='%s', `coefficientA`='%s', `coefficientB`='%s', `coefficientS`='%s', `estimatedFireLoad`='%s'," +
//			" `proemnostOfRoom`='%s', `averageAmountOfCombustionAir`='%s', `specificCriticalAmountOfFireLoad`='%s'," +
//			" `specificValueOfFireLoad`='%s', `PRN`='%s', `maximumMeanBulkTemperature`='%s', `durationOfFireSurround`='%s'," +
//			" `timeReachMaximumMeanBulkTemperature`='%s', `maximumAverageTemperatureOfWallSurface`='%s'," +
//			" `timeToReachMaximumTemperatureOfWallSurface`='%s', `averageMaximumTemperatureOfSlab`='%s'," +
//			" `timeToReachMaximumTemperatureOfSlabSurface`='%s', `fk.id.building`='%s' WHERE `id.room`='%d';";
//	public static final String SQL_QUERY_CREATE_ROOM = "INSERT INTO `room` (`positionOfRoom`,`nameOfRoom`,`square`,`height`,`perimeter`,`volume`,`squareOfConstruction`," +
//			"`specificFireLoad`," +"`specificFireLoadZVEZDOCHKA`,"+
//			"`reducedHeightOfApertures`,`generalSquareOfApertures`,`ventilationParameter`,`coefficientK`,`coefficientA`," +
//			"`coefficientB`,`coefficientS`,`estimatedFireLoad`,`proemnostOfRoom`,`averageAmountOfCombustionAir`," +
//			"`specificCriticalAmountOfFireLoad`,`specificValueOfFireLoad`,`PRN`,`maximumMeanBulkTemperature`," +
//			"`durationOfFireSurround`,`timeReachMaximumMeanBulkTemperature`,`maximumAverageTemperatureOfWallSurface`," +
//			"`timeToReachMaximumTemperatureOfWallSurface`,`averageMaximumTemperatureOfSlab`," +
//			"`timeToReachMaximumTemperatureOfSlabSurface`,`fk.id.building`) "+
//			"VALUES ('%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s'," +
//			"'%s','%s','%d','%s','%s','%s','%s','%s','%s','%s','%d');";


    /////////////newRoom\\\\\\\\\\\\\\
    public static final String GET_ROOMS = "SELECT * FROM `room` ";
    public static final String DELETE_ROOM = "DELETE FROM `room` WHERE `id.room` = ?;";
    public static final String UPDATE_ROOM = "UPDATE `room` SET `positionOfRoom`=?, `nameOfRoom`=?, `square`=?," +
            " `height`=?, `perimeter`=?, `volume`=?, `squareOfConstruction`=?, `specificFireLoad`=?," +
            " `reducedHeightOfApertures`=?, `generalSquareOfApertures`=?, `ventilationParameter`=?," +
            " `coefficientK`=?, `coefficientA`=?, `coefficientB`=?, `coefficientS`=?, `estimatedFireLoad`=?," +
            " `proemnostOfRoom`=?, `averageAmountOfCombustionAir`=?, `specificCriticalAmountOfFireLoad`=?," +
            " `specificValueOfFireLoad`=?, `PRN`=?, `maximumMeanBulkTemperature`=?, `durationOfFireSurround`=?," +
            " `timeReachMaximumMeanBulkTemperature`=?, `maximumAverageTemperatureOfWallSurface`=?," +
            " `timeToReachMaximumTemperatureOfWallSurface`=?, `averageMaximumTemperatureOfSlab`=?," +
            " `timeToReachMaximumTemperatureOfSlabSurface`=?, `fk.id.building`=? WHERE `id.room`=?;";
    public static final String CREATE_ROOM = "INSERT INTO `room` (`positionOfRoom`,`nameOfRoom`,`square`,`height`,`perimeter`,`volume`,`squareOfConstruction`," +
            "`specificFireLoad`," + "`specificFireLoadZVEZDOCHKA`," +
            "`reducedHeightOfApertures`,`generalSquareOfApertures`,`ventilationParameter`,`coefficientK`,`coefficientA`," +
            "`coefficientB`,`coefficientS`,`estimatedFireLoad`,`proemnostOfRoom`,`averageAmountOfCombustionAir`," +
            "`specificCriticalAmountOfFireLoad`,`specificValueOfFireLoad`,`PRN`,`maximumMeanBulkTemperature`," +
            "`durationOfFireSurround`,`timeReachMaximumMeanBulkTemperature`,`maximumAverageTemperatureOfWallSurface`," +
            "`timeToReachMaximumTemperatureOfWallSurface`,`averageMaximumTemperatureOfSlab`," +
            "`timeToReachMaximumTemperatureOfSlabSurface`,`fk.id.building`) " +
            "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?," +
            "?,?,?,?,?,?,?,?,?,?,?);";
    public static final String GET_ROOM_BY_ID = "SELECT * FROM `room` WHERE `id.room` = ?;";
    public static final String GET_ROOM_BY_FkID_BUILDING = "SELECT * FROM `room` WHERE `fk.id.building` = ?;";

//	//////////////CoefficientSForBuild\\\\\\\\\\
//	public static final String SQL_QUERY_GET_CoefficientSForBuild = "SELECT * FROM `coefficientSForBuilding` ";
//	public static final String SQL_QUERY_DELETE_CoefficientSForBuild = "DELETE FROM `coefficientSForBuilding` WHERE `id.coefficientSForBuilding`='%d';";
//	public static final String SQL_QUERY_UPDATE_CoefficientSForBuild = "UPDATE `coefficientSForBuilding` SET `fk.id.building`='%d', `s2`='%s', `s3`='%s', `s5`='%s', `s6`='%s' "+
//			"WHERE `id.coefficientSForBuilding`='%d';";
//	public static final String SQL_QUERY_CREATE_CoefficientSForBuild = "INSERT INTO `coefficientSForBuilding` (`fk.id.Building`,`s2`,`s3`,`s5`,`s6`) "+
//			"VALUES ('%d','%s','%s','%s','%s');";

    //////////////newCoefficientSForBuild\\\\\\\\\\
    public static final String GET_CoefficientSForBuild = "SELECT * FROM `coefficientSForBuilding` ";
    public static final String DELETE_CoefficientSForBuild = "DELETE FROM `coefficientSForBuilding` WHERE `id.coefficientSForBuilding`=?;";
    public static final String UPDATE_CoefficientSForBuild = "UPDATE `coefficientSForBuilding` SET `fk.id.building`=?, `s2`=?, `s3`=?, `s5`=?, `s6`=? " +
            "WHERE `id.coefficientSForBuilding`=?;";
    public static final String CREATE_CoefficientSForBuild = "INSERT INTO `coefficientSForBuilding` (`fk.id.Building`,`s2`,`s3`,`s5`,`s6`) " +
            "VALUES (?,?,?,?,?);";
    public static final String GET_CoefficientSForBuild_BY_ID = "SELECT * FROM `coefficientSForBuilding` WHERE `id.coefficientSForBuilding`=?;";
    public static final String GET_CoefficientSForBuild_BY_FK_BUILDING = "SELECT * FROM `coefficientSForBuilding` WHERE `fk.id.Building` = ?;";


//	////////////CoefficientSForRoom\\\\\\\\\\\\\\\
//	public static final String SQL_QUERY_GET_CoefficientSForRoom = "SELECT * FROM `coefficientSForRoom` ";
//	public static final String SQL_QUERY_DELETE_CoefficientSForRoom = "DELETE FROM `coefficientSForRoom` WHERE `id.coefficientSForRoom`='%d';";
//	public static final String SQL_QUERY_UPDATE_CoefficientSForRoom = "UPDATE `coefficientSForRoom` SET `fk.id.room`='%d', `s1`='%s', `s4`='%s', `s7`='%s', `s8`='%s', `s9`='%s', `s10`='%s' "+
//			"WHERE `id.coefficientSForRoom`='%d';";
//	public static final String SQL_QUERY_CREATE_CoefficientSForRoom = "INSERT INTO `coefficientSForRoom` (`fk.id.room`,`s1`,`s4`,`s7`,`s8`,`s9`,`s10`) "+
//			"VALUES ('%d','%s','%s','%s','%s','%s','%s');";

    ////////////newCoefficientSForRoom\\\\\\\\\\\\\\\
    public static final String GET_CoefficientSForRoom = "SELECT * FROM `coefficientSForRoom` ";
    public static final String DELETE_CoefficientSForRoom = "DELETE FROM `coefficientSForRoom` WHERE `id.coefficientSForRoom`=?;";
    public static final String UPDATE_CoefficientSForRoom = "UPDATE `coefficientSForRoom` SET `fk.id.room`=?, `s1`=?, `s4`=?, `s7`=?, `s8`=?, `s9`=?, `s10`=? " +
            "WHERE `id.coefficientSForRoom`=?;";
    public static final String CREATE_CoefficientSForRoom = "INSERT INTO `coefficientSForRoom` (`fk.id.room`,`s1`,`s4`,`s7`,`s8`,`s9`,`s10`) " +
            "VALUES (?,?,?,?,?,?,?);";
    public static final String GET_CoefficientSForRoom_BY_ID = "SELECT * FROM `coefficientSForRoom` WHERE `id.coefficientSForRoom`=?;";
    public static final String GET_CoefficientSForRoom_BY_FK_BUILDING = "SELECT * FROM `coefficientSForRoom` WHERE `fk.id.room` = ?;";


//	/////////////////Aperture\\\\\\\\\\\\\\\\\\
//	public static final String SQL_QUERY_GET_APERTURES = "SELECT * FROM `aperture` ";
//	public static final String SQL_QUERY_DELETE_APERTURE = "DELETE FROM `aperture` WHERE `id.user` = %d;";
//	public static final String SQL_QUERY_UPDATE_APERTURE = "UPDATE `aperture` SET `typeOfAperture` = '%s', `height` = '%s', `width` = '%s', " +
//			"`squareOfAperture`='%s', `count`='%s', `fk.id.room`='%s' WHERE `id.aperture` = %d;";
//	public static final String SQL_QUERY_CREATE_APERTURE = "insert INTO aperture(`typeOfAperture`,`height`,`width`,`squareOfAperture`,`count`,`fk.id.room`)" +
//			" values('%s','%s','%s','%s',%d,'%s');";

    /////////////////newAperture\\\\\\\\\\\\\\\\\\
    public static final String GET_APERTURES = "SELECT * FROM `aperture` ";
    public static final String DELETE_APERTURE = "DELETE FROM `aperture` WHERE `id.aperture` = ?;";
    public static final String UPDATE_APERTURE = "UPDATE `aperture` SET `typeOfAperture` = ?, `height` = ?, `width` = ?, " +
            "`squareOfAperture`=?, `count`=?, `fk.id.room`=? WHERE `id.aperture` = ?;";
    public static final String CREATE_APERTURE = "insert INTO aperture(`typeOfAperture`,`height`,`width`,`squareOfAperture`,`count`,`fk.id.room`)" +
            " values(?,?,?,?,?,?);";
    public static final String GET_APERTURE_BY_ID = "SELECT * FROM `aperture` WHERE `id.aperture`=?;";
    public static final String GET_APERTURE_BY_FK_ROOM = "SELECT * FROM `aperture` WHERE `fk.id.room` = ?;";


//	/////////////////ChangeWallsTemperature\\\\\\\\\\\
//	public static final String SQL_QUERY_GET_ChangeWallsT = "SELECT * FROM `changeInTemperatureOfWalls` ";
//	public static final String SQL_QUERY_DELETE_ChangeWallsT = "DELETE FROM `changeInTemperatureOfWalls` " +
//			"WHERE `id.changeInTemperatureOfWalls` = %d;";

    /////////////////newChangeWallsTemperature\\\\\\\\\\\
    public static final String GET_ChangeWallsT = "SELECT * FROM `changeInTemperatureOfWalls` ";
    public static final String DELETE_ChangeWallsT = "DELETE FROM `changeInTemperatureOfWalls` " +
            "WHERE `id.changeInTemperatureOfWalls` = ?;";
    public static final String GET_ChangeWallsT_BY_ID = "SELECT * FROM `changeInTemperatureOfWalls` WHERE `id.changeInTemperatureOfWalls`=?;";
    public static final String GET_ChangeWallsT_BY_FK_ROOM = "SELECT * FROM `changeInTemperatureOfWalls` WHERE `fk.id.room` = ?;";

//	/////////////////ChangeSlabTemperature\\\\\\\\\\\
//	public static final String SQL_QUERY_GET_ChangeSlabT = "SELECT * FROM `changeInTemperatureOfSlab` ";
//	public static final String SQL_QUERY_DELETE_ChangeSlabT = "DELETE FROM `changeInTemperatureOfSlab` " +
//			"WHERE `id.changeInTemperatureOfSlab` = %d;";

    /////////////////newChangeSlabTemperature\\\\\\\\\\\
    public static final String GET_ChangeSlabT = "SELECT * FROM `changeInTemperatureOfSlab` ";
    public static final String DELETE_ChangeSlabT = "DELETE FROM `changeInTemperatureOfSlab` " +
            "WHERE `id.changeInTemperatureOfSlab` = ?;";
    public static final String GET_ChangeSlabT_BY_ID = "SELECT * FROM `changeInTemperatureOfSlab` WHERE `id.changeInTemperatureOfSlab`=?;";
    public static final String GET_ChangeSlabT_BY_FK_ROOM = "SELECT * FROM `changeInTemperatureOfSlab` WHERE `fk.id.room` = ?;";

//	/////////////////ChangeMeanBulkTemperature\\\\\\\\\\\
//	public static final String SQL_QUERY_GET_ChangeMeanBulkT = "SELECT * FROM `changeInMeanBulkTemperature` ";
//	public static final String SQL_QUERY_DELETE_ChangeMeanBulkT = "DELETE FROM `changesinmeanbulktemperature` " +
//			"WHERE `id.changesinmeanbulktemperature` = %d;";

    /////////////////newChangeMeanBulkTemperature\\\\\\\\\\\
    public static final String GET_ChangeMeanBulkT = "SELECT * FROM `changeInMeanBulkTemperature` ";
    public static final String DELETE_ChangeMeanBulkT = "DELETE FROM `changesinmeanbulktemperature` " +
            "WHERE `id.changesinmeanbulktemperature` = ?;";
    public static final String GET_ChangeMeanBulkT_BY_ID = "SELECT * FROM `changesinmeanbulktemperature` WHERE `id.changesinmeanbulktemperature`=?;";
    public static final String GET_ChangeMeanBulkT_BY_FK_ROOM = "SELECT * FROM `changesinmeanbulktemperature` WHERE `fk.id.room` = ?;";

//	///////////////SubstanceOfRoom\\\\\\\\\\\\\\\\\\\\
//	public static final String SQL_QUERY_GET_SubstancesOfRoom = "SELECT * FROM `substancesOfRoom` ";
//	public static final String SQL_QUERY_DELETE_SubstancesOfRoom = "DELETE FROM `substancesOfRoom` WHERE `id.substancesOfRoom` ='%d';";
//	public static final String SQL_QUERY_UPDATE_SubstancesOfRoom = "UPDATE `substancesOfRoom` SET `fk.id.room` = '%s', `fk.id.substance` = '%s', `weight` = '%s' " +
//			" WHERE `id.substancesOfRoom` = %d";
//	public static final String SQL_QUERY_CREATE_SubstancesOfRoom = "insert INTO `substancesOfRoom`(`fk.id.room`,`fk.id.substance`,`weight`)" +
//			" values('%s','%s','%s');";

    ///////////////newSubstancesOfRoom\\\\\\\\\\\\\\\\\\\\
    public static final String GET_SubstancesOfRoom = "SELECT * FROM `substancesOfRoom` ";
    public static final String DELETE_SubstancesOfRoom = "DELETE FROM `substancesOfRoom` WHERE `id.substancesOfRoom` =?;";
    public static final String UPDATE_SubstancesOfRoom = "UPDATE `substancesOfRoom` SET `fk.id.room` = ?, `fk.id.substance` = ?, `weight` = ? " +
            " WHERE `id.substancesOfRoom` = ?";
    public static final String CREATE_SubstancesOfRoom = "insert INTO `substancesOfRoom`(`fk.id.room`,`fk.id.substance`,`weight`)" +
            " values(?,?,?);";
    public static final String GET_SubstancesOfRoom_BY_ID = "SELECT * FROM `substancesOfRoom` WHERE `id.substancesOfRoom`=?;";
    public static final String GET_SubstancesOfRoom_BY_FK_ROOM = "SELECT * FROM `substancesOfRoom` WHERE `fk.id.room` = ?;";

//	//////////////////FlammableSubstances\\\\\\\\\\\\\\\
//	public static final String SQL_QUERY_GET_FlammableSubstance = "SELECT * FROM `flammableSubstance` ";
//	public static final String SQL_QUERY_DELETE_FlammableSubstance = "DELETE FROM `flammableSubstance` WHERE `id.substance` ='%d';";
//	public static final String SQL_QUERY_UPDATE_FlammableSubstance = "UPDATE `flammableSubstance` SET `nameOfSubstance` = '%s', `amountOfCombustionAir` = '%s', " +
//			"`averageSpeedBurnout` = '%s',`combustionHeat`='%s' WHERE `id.substance` ='%d';";
//	public static final String SQL_QUERY_CREATE_FlammableSubstance = "insert INTO `flammableSubstance`(`nameOfSubstance`,`amountOfCombustionAir`,`averageSpeedBurnout`,`combustionHeat`)" +
//			" values('%s','%s','%s','%s');";

    //////////////////newFlammableSubstances\\\\\\\\\\\\\\\
    public static final String GET_FlammableSubstance = "SELECT * FROM `flammableSubstance` ";
    public static final String DELETE_FlammableSubstance = "DELETE FROM `flammableSubstance` WHERE `id.substance` =?;";
    public static final String UPDATE_FlammableSubstance = "UPDATE `flammableSubstance` SET `nameOfSubstance` = ?, `amountOfCombustionAir` = ?, " +
            "`averageSpeedBurnout` = ?,`combustionHeat`=? WHERE `id.substance` =?;";
    public static final String CREATE_FlammableSubstance = "insert INTO `flammableSubstance`(`nameOfSubstance`,`amountOfCombustionAir`,`averageSpeedBurnout`,`combustionHeat`)" +
            " values(?,?,?,?);";
    public static final String GET_FLAMMABLE_SUBSTANCE_BY_ID = "SELECT * FROM `flammableSubstance` WHERE `id.substance`=?;";


    private SqlRequests() {
    }
}