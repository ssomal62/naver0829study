package typing.day001;


public class FitNesseContext {

    Root root;

    public FitNesseContext setDeadEndStrategy(){
        FitNesseContext fitNesseContext = new FitNesseContext();
        return fitNesseContext;
    }

}

class Root{

    public PageCrawler getPageCrawler(){
        PageCrawler pageCrawler = new PageCrawler();
        return pageCrawler;
    }

}