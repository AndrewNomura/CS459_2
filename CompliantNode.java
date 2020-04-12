import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

/* CompliantNode refers to a node that follows the rules (not malicious)*/
public class CompliantNode implements Node {

	public boolean[] confirmedFollowees; 
	public Set<Transaction> txs;

	private boolean[] blacklisted;

	double graph, malicious, txDist;
	int rounds;

    public CompliantNode(double p_graph, double p_malicious, double p_txDistribution, int numRounds) {
    
        graph = p_graph;
        malicious = p_malicious;
        txDist = p_txDistribution;
    	rounds = numRounds;
        
    	txs = new HashSet<Transaction>(); 
    }

    public void setFollowees(boolean[] followees) {
    	confirmedFollowees = followees;
    	blacklisted = new boolean[followees.length];
    }

    public void setPendingTransaction(Set<Transaction> pendingTransactions) {
        
    	for(Transaction tx : pendingTransactions){
    		txs.add(tx);
    	}

    }

    public Set<Transaction> getProposals(){

    	Set<Transaction> proposals = new HashSet<>(txs);
    	txs.clear();

    	return proposals;

    }

    public void receiveCandidates(ArrayList<Integer[]> candidates) {
    	
        Set<Integer> senders = new HashSet<Integer>();

    	int nodeIndex;

    	for(int i = 0; i < candidates.size(); i++){
    		nodeIndex = candidates.get(i)[1];
            if(!senders.contains(nodeIndex)){
                senders.add(nodeIndex);
            }
    	}

    	for(int i = 0; i < confirmedFollowees.length; i++){
            if(confirmedFollowees[i] && !senders.contains(i)){
                blacklisted[i] = true;
            }
        }
		
    	for(int i = 0; i < candidates.size(); i++){
    		if(!blacklisted[candidates.get(i)[1]]){
    			txs.add(new Transaction(candidates.get(i)[0]));
    		}
    	}

    }
}
