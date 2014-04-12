import java.awt.Point;


public class Worker {
	Body body = null;
	Engine engine = null;
	Tire tire = null;
	WorkSite workSite;
	BodyFactory bodyFactory;
	EngineFactory engineFactory;
	TireFactory tireFactory;
	Request request;
	Point position;
	String []image;
	int ID;
	
	/**
	 * Inicializa funcionário
	 * @param workSite Local de Trabalho do Funcionário
	 * @param ID ID do funcionário (deve ser a mesma do workSite)
	 */
	public Worker(WorkSite workSite, int ID, BodyFactory bodyFactory, EngineFactory engineFactory, TireFactory tireFactory)
	{
		this.bodyFactory = bodyFactory;
		this.engineFactory = engineFactory;
		this.tireFactory = tireFactory;
		this.workSite = workSite;
		request = null;
		this.ID = ID;
		this.position = Positions.getWorkerInitialPosition(ID);
		this.image = Images.getWorker();
	}
	
	/**
	 * Dá um pedido ao funcionário
	 * @param request Pedido a ser recebido
	 */
	public void receiveRequest(Request request)
	{
		this.request = request;
	}
	
	/**
	 * @return Se o funcionário está livre (sem pedidos) retorna true; caso contrário, false
	 */
	public boolean isFree()
	{
		if(request == null) return true;
		return false;
	}
	
	public void Update()
	{
		boolean bodyPlaced = false;
		boolean enginePlaced = false;
		boolean tirePlaced = false;
		
		if(request != null)
		{
			bodyFactory.newRequest(request.bodyType);
			engineFactory.newRequest(request.engineType);
			tireFactory.newRequest(request.tireType);
			
			while (!bodyPlaced || !enginePlaced || !tirePlaced)
			{
				if (!bodyPlaced && bodyFactory.hasABody(request.bodyType))
				{
					workSite.addPart(bodyFactory.takeProduct(request.bodyType));
					bodyPlaced = true;
				}
				
				if (!enginePlaced && engineFactory.hasAEngine(request.engineType))
				{
					workSite.addPart(engineFactory.takeProduct(request.engineType));
					enginePlaced = true;
				}
				
				if (!tirePlaced && tireFactory.hasATire(request.tireType))
				{
					workSite.addPart(tireFactory.takeProduct(request.tireType));
					tirePlaced = true;
				}
			}
		}
	}
	
	/**
	 * Imprime imagem do funcionário
	 * @param draw Local para impressão
	 */
	public void Draw(Draw draw)
	{
		draw.addPrint(image, position);
	}

}
