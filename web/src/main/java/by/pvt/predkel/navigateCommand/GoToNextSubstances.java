package by.pvt.predkel.navigateCommand;

/**
 *
 */
//public class GoToNextSubstances extends AbstractCommand {
//
//    @Override
//    public String execute(HttpServletRequest request, HttpServletResponse response) {
//        Integer page;
//        try {
//            page=Integer.valueOf(request.getParameter(Parameters.PAGE));
//        }catch (NullPointerException e){
//            page=1;
//        }
//
//        Integer maxResult=1;
//        Integer countOfPages=1;
//        List<FlammableSubstance> substances = null;
//        try {
//            Long countOfSubstances=FlammableSubstanceService.getInstance().getCountOfSubstances();
//            countOfPages=new BigDecimal(countOfSubstances/maxResult).setScale(0, RoundingMode.UP).intValue();
//            substances = FlammableSubstanceService.getInstance().getSubstancesForPage(page,maxResult);
//        } catch (DaoException e) {
//            MyLogger.INSTANCE.logError(getClass(), e.getMessage());
//            request.setAttribute(Attributes.ERROR, Errors.DB_ERROR);
//        }
//        if (countOfPages==0) countOfPages++;
//        request.setAttribute(Attributes.ALL_SUBSTANCES, substances);
//        request.setAttribute(Attributes.COUNT_OF_PAGES,countOfPages);
//        request.setAttribute(Attributes.PAGE,page);
//        return Path.SUBSTANCES_PATH;
//    }
//}
