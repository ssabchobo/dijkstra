package dijkstra;

public class Graph 
{
	private int n;           //������ ��
    private int maps[][];    //���鰣�� ����ġ ������ ����
 
    public Graph(int n){
        this.n = n; //����� ���� �ʱ�ȭ
        maps = new int[n+1][n+1]; //����ġ ����� �ʱ�ȭ         
    }
    //i,j:����� 2���� ���, w:����ġ
    public void input(String x,String y,int w)
    {//�������� ��� ���� �� ���� 
    	int i=x.charAt(1);
    	int j=y.charAt(1);
    	maps[i][j] = w;
        maps[j][i] = w;
    }	
    public void dijkstra(int v)
    {
        int distance[] = new int[n+1];          //�ִ� �Ÿ��� ������ ����(distance[2]�� ���۳�忡�� 2������ ���µ� �־� �ִܰŸ� ����ġ ���̶� ��)
        boolean[] check = new boolean[n+1];     //�ش� ��带 �湮�ߴ��� üũ�� ����
         
        //distance�� �ʱ�ȭ.(����ġ ������ integer�� ���� �� �ִ� �ִ��� ������ �ʱ�ȭ) 
        for(int i=1;i<n+1;i++)
        {
            distance[i] = Integer.MAX_VALUE;
        }
         
        //���۳�尪 �ʱ�ȭ, �湮���� üũ
        distance[v] =0;
        check[v] =true;
         
        //������ distance����
        for(int i=1;i<n+1;i++)
        {//��� ��带 ���鼭, �湮���� �ʰ�, ����ġ�� �ִ� ���(����Ȱ��)
         //distance �ִ� �Ÿ� ����ġ ������ ����ġ ����(ó�� �����ϴ� ���� ����Ǿ� �ִ� ���鰣�� �ִ�Ÿ�)
            if(!check[i] && maps[v][i] !=0){
                distance[i] = maps[v][i];
            }
        }
          
        for(int a=0;a<n-1;a++)
        {
            //������ ��� ��尡 true�ɶ����� �ε�
            //��尡 n�� ���� �� ���ͽ�Ʈ�� ���ؼ� �ݺ����� n-1���̸� �ȴ�.
            //������ ������ ������ ��尡 ��� true���� Ȯ���ϴ� ������ �����ص� �ȴ�.
            int min=Integer.MAX_VALUE;
            int min_index=-1;//�ּ� �Ÿ� ����ġ�� ���� �� �ִ� ��� idex �ӽú��� �ʱ�ȭ
             
            //�ּҰ� ã��
            for(int i=1;i<n+1;i++)
            {//�湮���� �ʾҰ�, ����� ��尡 �ִ� ���(MAX_Value�� �ִٴ� ���� ���� �������̵� ������ �ȵǾ� �ִٴ� ��)
                if(!check[i] && distance[i]!=Integer.MAX_VALUE)
                {
                    if(distance[i]<min )
                    {
                        min=distance[i];
                        min_index = i;
                    }
                }
            }
             
            check[min_index] = true;//�湮ǥ��
            for(int i=1;i<n+1;i++)
            {//�湮���� �ʾҰ�, min_index �ּ� ����ġ�� ������ ���� ����Ǿ� �ִ� ���
                if(!check[i] && maps[min_index][i]!=0)
                {
                    if(distance[i]>distance[min_index]+maps[min_index][i])
                    {//���� �ջ�� �ּ� ����ġ ���� �ٸ� ��Ʈ�� ���� �ջ�� ����ġ���� ũ�� �ּҰŸ� �� ��ü
                        distance[i] = distance[min_index]+maps[min_index][i];
                    }
                }
            }
 
        }
         
        //����� ���
        for(int i=1;i<n+1;i++)
        {
            System.out.print(distance[i]+" ");
        }
        System.out.println("");
         
    }
}