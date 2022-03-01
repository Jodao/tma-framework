package eubr.atmosphere.tma.utils;

public class ResourceConsumptionScoreTalkConnect implements Score {

    public ResourceConsumptionScoreTalkConnect() {
        super();
        this.cpuContainers = 0.0;
        this.memoryContainers = 0.0;
        this.numberContainers = 0.0;
    }

    private Double cpuContainers;
    private Double memoryContainers;
    private Double numberContainers;
    private Double score;
    private int metricId;
    private int resourceId;
    private long valueTime;

    public Double getCpuContainers() {
        return cpuContainers;
    }

    public void setCpuContainers(Double cpuContainers) {
        this.cpuContainers = cpuContainers;
    }

    public Double getMemoryContainers() {
        return memoryContainers;
    }

    public void setMemoryContainers(Double memoryContainers) {
        this.memoryContainers = memoryContainers;
    }

    public Double getNumberContainers() {
        return numberContainers;
    }

    public void setNumberContainers(Double numberContainers) {
        this.numberContainers = numberContainers;
    }

    @Override
    public String toString() {
        return "Score [cpuContainers: " + this.getCpuContainers() +
              ", memoryContainers: " + this.getMemoryContainers() +
              ", numberContainers: " + this.getNumberContainers() + "]";
    }

    @Override
    public Double getScore() {
        //Divide by 100 to normalize between 0 and 1, since those data arrive as %
        Double a1 = this.getCpuContainers()/100;
        Double a2 = this.getMemoryContainers()/100;
        Double a3 = this.getNumberContainers();
        Double a4 = 0.65 * a1 + 0.35 * a2;    
        this.score = a4 / a3;

        return this.score;
    }

    public String getCsvLine() {
        return this.getCpuContainers().toString() +
            "," + this.getMemoryContainers().toString() +
            "," + this.getNumberContainers().toString() +
            "," + this.getScore().toString();
    }

    public boolean isValid() {
         return this.getCpuContainers()!= null && this.getMemoryContainers()!= null 
                 && this.getNumberContainers()!= null;
    }

	@Override
	public long getValueTime() {
		return this.valueTime;
	}

	public void setValueTime(long valueTime) {
		this.valueTime = valueTime;
	}

	@Override
	public int getResourceId() {
		return this.resourceId;
	}

	public void setResourceId(int resourceId) {
		this.resourceId = resourceId;
	}
	
	@Override
	public int getMetricId() {
		return this.metricId;
	}

	public void setMetricId(int metricId) {
		this.metricId = metricId;
	}
}
