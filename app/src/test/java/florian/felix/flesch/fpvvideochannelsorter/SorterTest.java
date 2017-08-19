package florian.felix.flesch.fpvvideochannelsorter;

import java.util.ArrayList;

import org.junit.Test;

import florian.felix.flesch.fpvvideochannelsorter.sorterlogic.Sorter;
import static org.junit.Assert.*;

/**
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class SorterTest {
    @Test
    public void bandR_4pilots() throws Exception {
    	ArrayList<Pilot> pilots = new ArrayList<>();
		addPilot(pilots, false, false, false, false, true, false);
		addPilot(pilots, false, false, false, false, true, false);
		addPilot(pilots, false, false, false, false, true, false);
		addPilot(pilots, false, false, false, false, true, false);
		ArrayList<Pilot> solution = Sorter.sort(pilots, 0, Integer.MAX_VALUE);
		assertSolution(new int[]{5658, 5732, 5843, 5917}, solution);
    }
    
    @Test
    public void bandA_4pilots() throws Exception {
    	ArrayList<Pilot> pilots = new ArrayList<>();
		addPilot(pilots, true, false, false, false, false, false);
		addPilot(pilots, true, false, false, false, false, false);
		addPilot(pilots, true, false, false, false, false, false);
		addPilot(pilots, true, false, false, false, false, false);
		ArrayList<Pilot> solution = Sorter.sort(pilots, 0, Integer.MAX_VALUE);
		assertSolution(new int[]{5865, 5825, 5765, 5725}, solution);
    }
    
    @Test
    public void bandE_4pilots() throws Exception {
    	ArrayList<Pilot> pilots = new ArrayList<>();
		addPilot(pilots, false, false, true, false, false, false);
		addPilot(pilots, false, false, true, false, false, false);
		addPilot(pilots, false, false, true, false, false, false);
		addPilot(pilots, false, false, true, false, false, false);
		ArrayList<Pilot> solution = Sorter.sort(pilots, 0, Integer.MAX_VALUE);
		assertSolution(new int[]{5705, 5645, 5885, 5945}, solution);
    }
    
    private void addPilot(ArrayList<Pilot> pilots, boolean bandA, boolean bandB, boolean bandE, boolean bandF, boolean bandR, boolean bandD) {
    	pilots.add(new Pilot(pilots.size(), "Pilot", bandA, bandB, bandE, bandF, bandR, bandD));
    }
    
    private void assertSolution(int[] expected, ArrayList<Pilot> solution) {
    	for (int i=0; i<expected.length; i++) {
    		assertEquals(expected[i], solution.get(i).getFrequency().getFrequenz());
    	}
    }
}