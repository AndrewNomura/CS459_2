import java.util.ArrayList;
import java.util.Set

public class CompliantNode implements Node {
	
	private int num_of_rounds;
	private double graph;
	private double txDistribution;
	private double malicious_node;
	
	private boolean[] followees;
	private boolean[] black_listed;
	private Set<Transaction> pendingTransactions;
	
	public CompliantNode(int num_of_rounds, double graph, double txDistribution, double malicious_node){
		this.num_of_rounds = num_of_rounds;
		this.graph = graph;
		this.txDistribution = txDistribution;
		this.malicious_node = malicious_node;

	}

	public void setFollowees(boolean[] followees){
		this.followees = followees;	
		this.black_listed = new boolean[followees.length];
	}

	public void setPendingTransaction(Set<Transaction> pendingTransactions){
		this.pendingTransactions = pendingTransactions;

	}

	public Set<Transaction> sendToFollowers(){
		// IMPLEMENT THIS

	}

	public void receiveFromFollowees(ArrayList<Integer[]> candidates){
		//IMPLEMENT THIS
	}
}
