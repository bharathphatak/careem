package careem.processor;

/**
 * Created by bhara on 26-02-2017.
 */
public class WareHouseHubLink {


        class Edge {
            int src, dest, weight;
            Edge() {
                src = dest = weight = 0;
            }
        };

        int V, E;
        Edge edge[];


        WareHouseHubLink(int v, int e)
        {
            V = v;
            E = e;
            edge = new Edge[e];
            for (int i=0; i<e; ++i)
                edge[i] = new Edge();
        }
}
