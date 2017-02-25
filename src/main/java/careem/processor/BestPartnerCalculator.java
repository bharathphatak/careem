package careem.processor;

import java.util.HashMap;
import java.util.List;

/**
 * Created by bhara on 26-02-2017.
 */
public class BestPartnerCalculator {
    private WareHouseHubLink wareHouseHubLink;
    
    public BestPartnerCalculator(WareHouseHubLink wareHouseHubLink){
        this.wareHouseHubLink = wareHouseHubLink;
    }
    
    public int getMinRate(int source,int destination){

            int V = wareHouseHubLink.V, E = wareHouseHubLink.E;
            int dist[] = new int[V];

            HashMap<Integer,List<String>> maps = new HashMap<Integer, List<String>>();


            for (int i=0; i<V; ++i)
                dist[i] = Integer.MAX_VALUE;
            dist[source] = 0;

            for (int i=1; i<V; ++i)
            {
                for (int j=0; j<E; ++j)
                {

                    int u = wareHouseHubLink.edge[j].src;
                    int v = wareHouseHubLink.edge[j].dest;
                    int weight = wareHouseHubLink.edge[j].weight;
                    if (dist[u] != Integer.MAX_VALUE &&
                            dist[u] + weight < dist[v]) {
                        dist[v] = dist[u] + weight;

                    }

                }
            }
            return dist[destination];
        }
}
