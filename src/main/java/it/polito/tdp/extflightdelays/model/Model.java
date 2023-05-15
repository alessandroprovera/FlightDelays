package it.polito.tdp.extflightdelays.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import it.polito.tdp.extflightdelays.db.ExtFlightDelaysDAO;

public class Model {
	
	private Graph<Airport,DefaultWeightedEdge> grafo;
	private ExtFlightDelaysDAO dao;
	private Map<Integer, Airport> idMapAirport;
	
	public Model() {
		grafo = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);
		dao = new ExtFlightDelaysDAO();
		idMapAirport = new HashMap<>();
		this.dao.loadAllAirports(idMapAirport);
	}
	
	public void creaGrafo(int n) {
		Graphs.addAllVertices(grafo, this.dao.getVertici(n, idMapAirport));
		List<Rotta> rotte = this.dao.getEdges(idMapAirport);
		
		for(Rotta e: rotte) {
			Airport origin = e.getOrigin();
			Airport destination = e.getDestination();
			int N = e.getPeso();
			
			if(grafo.containsVertex(origin) && grafo.containsVertex(destination)) {
				DefaultWeightedEdge edge = this.grafo.getEdge(origin, destination);
				
				if(edge != null) {
					double weight = this.grafo.getEdgeWeight(edge);
					weight+=N;
					this.grafo.setEdgeWeight(edge, weight);
				}else {
					this.grafo.addEdge(origin, destination);
					this.grafo.setEdgeWeight(origin, destination, N);
				}
		}
		}
		System.out.println("Grafo creato");
		System.out.println(this.grafo.vertexSet().size());
		System.out.println(this.grafo.edgeSet().size());
	}
	
}



















