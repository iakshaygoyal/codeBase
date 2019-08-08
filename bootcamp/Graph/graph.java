package bootcamp.Graph;
import java.util.*;
public class graph {
	private class edge{
		vertex v1;
		vertex v2;
		int wt;
		edge(vertex v1,vertex v2,int wt){
			this.v1=v1;
			this.v2=v2;
			this.wt=wt;
		}
	}
	private class vertex{
		int name;
		HashMap<vertex,edge> map;
		vertex(int name){
			this.name=name;
			map=new HashMap<>();
		}
		public ArrayList<vertex> getAdjacentVertices(){
			return new ArrayList<>(this.map.keySet());
		}
		public ArrayList<edge> getAdjacentEdges(){
			return new ArrayList<>(this.map.values());
		}
	}
	ArrayList<vertex> vertices;
	graph(){
		vertices=new ArrayList<>();
	}
	public void addVertex(int name){
		vertex newvertex=new vertex(name);
		vertices.add(newvertex);
	}
	public vertex getVertex(int name){
		vertex retval=null;
		for(vertex v:vertices){
			if(v.name==name){
				retval=v;
				break;
			}
		}
		return retval;
	}
	public void addEdge(int name1,int name2,int wt){
		vertex v1=getVertex(name1);
		vertex v2=getVertex(name2);
		edge newedge=new edge(v1,v2,wt);
		v1.map.put(v2,newedge);
	}
	
	public static void main(String[] args){
		
	}
}
