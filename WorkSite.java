
public class WorkSite {
	Body body; 
	Tire tire;
	Engine engine;
	
	/**
	 * Inicializa o workSite (todas as partes são null)
	 */
	public WorkSite()
	{
		clearWorkSite(); // Marca todas as partes como null
	}
	
	/**
	 * @param body Adiciona a carcaça ao workSite
	 */
	public void addPart(Body body)
	{
		this.body = body;
	}
	
	/**
	 * @param tire Adiciona o pneu ao workSite
	 */
	public void addPart(Tire tire)
	{
		this.tire = tire;
	}
	
	/**
	 * @param engine Adiciona o motor ao workSite
	 */
	public void addPart(Engine engine)
	{
		this.engine = engine;
	}
	
	/**
	 * @return Se o carro tiver todas as partes, retorna true; caso contrário, false
	 */
	public boolean carIsComplete()
	{
		if(body != null && tire != null && engine != null) return true;
		return false;
	}
	
	/**
	 * Limpa local de trabalho (todas as partes vão para null)
	 */
	public void clearWorkSite()
	{
		this.body = null;
		this.tire = null;
		this.engine = null;
	}
	
	/**
	 * Atualiza as partes de carro existentes no workSite
	 */
	public void Update()
	{
		if(body != null) body.Update();
		if(tire != null) tire.Update();
		if(engine != null) engine.Update();
	}
	
	/**
	 * Imprime as partes de carro existentes no workSite
	 * @param draw Local para impressão
	 */
	public void Draw(Draw draw)
	{
		if(body != null) body.Draw(draw);
		if(tire != null) tire.Draw(draw);
		if(engine != null) engine.Draw(draw);
	}

}
