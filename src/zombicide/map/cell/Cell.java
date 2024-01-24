package zombicide.map.cell;


public abstract class Cell {
	protected List<Survivors> survivors;
	protected List<Zombies> zombies;
	protected int NoiseLevel;
	protected position Position;
	
	public Cell(int NoiseLevel,position Position) {
		
		this.NoiseLevel=NoiseLevel;
		this.Position=Position;
		this.survivors=new ArrayList<Survivors>();
		this.zombies=new ArrayList<Zombies>();
	}
	
	public void addZombies(Zombies z) {
		this.zombies.add(z);
	}
	
	public void addSurvivors(Survivors s) {
		this.survivors.add(s);
	}
	public void removeZombie(Zombies z) {
		this.zombies.remove(z);
	}
	
}
