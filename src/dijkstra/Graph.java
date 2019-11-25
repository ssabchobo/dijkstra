package dijkstra;

public class Graph 
{
	private int n;           //노드들의 수
    private int maps[][];    //노드들간의 가중치 저장할 변수
 
    public Graph(int n){
        this.n = n; //노드의 갯수 초기화
        maps = new int[n+1][n+1]; //가중치 저장소 초기화         
    }
    //i,j:연결된 2개의 노드, w:가중치
    public void input(String x,String y,int w)
    {//무방향일 경우 양쪽 다 저장 
    	int i=x.charAt(1);
    	int j=y.charAt(1);
    	maps[i][j] = w;
        maps[j][i] = w;
    }	
    public void dijkstra(int v)
    {
        int distance[] = new int[n+1];          //최단 거리를 저장할 변수(distance[2]은 시작노드에서 2노드까지 가는데 있어 최단거리 가중치 합이란 뜻)
        boolean[] check = new boolean[n+1];     //해당 노드를 방문했는지 체크할 변수
         
        //distance값 초기화.(가중치 변수에 integer가 가질 수 있는 최대의 값으로 초기화) 
        for(int i=1;i<n+1;i++)
        {
            distance[i] = Integer.MAX_VALUE;
        }
         
        //시작노드값 초기화, 방문유무 체크
        distance[v] =0;
        check[v] =true;
         
        //연결노드 distance갱신
        for(int i=1;i<n+1;i++)
        {//모든 노드를 돌면서, 방문하지 않고, 가중치가 있는 경우(연결된경우)
         //distance 최단 거리 가중치 변수에 가중치 세팅(처음 시작하는 노드와 연결되어 있는 노드들간의 최댄거리)
            if(!check[i] && maps[v][i] !=0){
                distance[i] = maps[v][i];
            }
        }
          
        for(int a=0;a<n-1;a++)
        {
            //원래는 모든 노드가 true될때까지 인데
            //노드가 n개 있을 때 다익스트라를 위해서 반복수는 n-1번이면 된다.
            //원하지 않으면 각각의 노드가 모두 true인지 확인하는 식으로 구현해도 된다.
            int min=Integer.MAX_VALUE;
            int min_index=-1;//최소 거리 가중치를 가질 수 있는 노드 idex 임시변수 초기화
             
            //최소값 찾기
            for(int i=1;i<n+1;i++)
            {//방문하지 않았고, 연결된 노드가 있는 경우(MAX_Value가 있다는 뜻은 아직 직간접이든 연결이 안되어 있다는 뜻)
                if(!check[i] && distance[i]!=Integer.MAX_VALUE)
                {
                    if(distance[i]<min )
                    {
                        min=distance[i];
                        min_index = i;
                    }
                }
            }
             
            check[min_index] = true;//방문표시
            for(int i=1;i<n+1;i++)
            {//방문하지 않았고, min_index 최소 가중치로 정해진 노드와 연결되어 있는 노드
                if(!check[i] && maps[min_index][i]!=0)
                {
                    if(distance[i]>distance[min_index]+maps[min_index][i])
                    {//현재 합산된 최소 가중치 합이 다른 루트를 통해 합산된 가중치보다 크면 최소거리 값 교체
                        distance[i] = distance[min_index]+maps[min_index][i];
                    }
                }
            }
 
        }
         
        //결과값 출력
        for(int i=1;i<n+1;i++)
        {
            System.out.print(distance[i]+" ");
        }
        System.out.println("");
         
    }
}