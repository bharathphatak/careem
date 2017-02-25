package careem.processor;

/**
 * Created by bhara on 26-02-2017.
 */
public class Processor {
    
    private WareHouseHubLink warehouseLink = null;
    private BestPartnerCalculator bestPartnerCalculator;

    public void Processor(){
        initWareHouseLink();
        bestPartnerCalculator = new BestPartnerCalculator(warehouseLink);
    }

    public void Processor(WareHouseHubLink wareHouseHubLink){
        this.warehouseLink = wareHouseHubLink;
        bestPartnerCalculator = new BestPartnerCalculator(wareHouseHubLink);
    }

    private void initWareHouseLink() {
        int V = 6;
        int E = 8;

        WareHouseHubLink wareHouseInitialisedData = new WareHouseHubLink(V, E);



        wareHouseInitialisedData.edge[0].src = 0;
        wareHouseInitialisedData.edge[0].dest = 1;
        wareHouseInitialisedData.edge[0].weight = 4;


        wareHouseInitialisedData.edge[1].src = 0;
        wareHouseInitialisedData.edge[1].dest = 3;
        wareHouseInitialisedData.edge[1].weight = 10;


        wareHouseInitialisedData.edge[2].src = 2;
        wareHouseInitialisedData.edge[2].dest = 0;
        wareHouseInitialisedData.edge[2].weight = 2;


        wareHouseInitialisedData.edge[3].src = 2;
        wareHouseInitialisedData.edge[3].dest = 4;
        wareHouseInitialisedData.edge[3].weight = 3;


        wareHouseInitialisedData.edge[4].src = 4;
        wareHouseInitialisedData.edge[4].dest = 3;
        wareHouseInitialisedData.edge[4].weight = 12;


        wareHouseInitialisedData.edge[5].src = 4;
        wareHouseInitialisedData.edge[5].dest = 1;
        wareHouseInitialisedData.edge[5].weight = 10;


        wareHouseInitialisedData.edge[6].src = 5;
        wareHouseInitialisedData.edge[6].dest = 4;
        wareHouseInitialisedData.edge[6].weight = 5;


        wareHouseInitialisedData.edge[7].src = 5;
        wareHouseInitialisedData.edge[7].dest = 0;
        wareHouseInitialisedData.edge[7].weight = 25;
        
        this.warehouseLink = wareHouseInitialisedData;
    }

    public int getBestPartner(int source,int destination){
        return bestPartnerCalculator.getMinRate(source,destination);
    }
}
