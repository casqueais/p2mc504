import java.awt.Point;


public class Worker {
	WorkSite workSite;
	Request request;
	Point position;
	String []image;
	int ID;
	
	/**
	 * Inicializa funcionário
	 * @param workSite Local de Trabalho do Funcionário
	 * @param ID ID do funcionário (deve ser a mesma do workSite)
	 */
	public Worker(WorkSite workSite, int ID)
	{
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
		if(request != null)
		{
			
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
