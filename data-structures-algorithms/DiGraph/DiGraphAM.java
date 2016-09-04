public class DiGraphAM
{
        private int[][] adjTable;
        
        public DiGraphAM(int n)
        {
                adjTable = new int[n][n];
        }
        
        public void addEdge(int v1, int v2)
        {
                adjTable[v1][v2]++;
        }
        
        public void deleteEdge(int v1, int v2)
        {
                adjTable[v1][v2]--;
        }
        
        public int edgeCount()
        {
                int answer = 0;
                for(int i = 0; i< adjTable.length; i++)
                {
                        for(int j = 0; j< adjTable.length; j++)
                        {
                                if(adjTable[i][j] == 1)
                                {
                                        answer++;
                                }
                        }
                }
                return answer;
        }
        
        public int vertexCount()
        {
                return adjTable.length;
        }
        
        public void print()
        {
                System.out.println("The content of the Table is:");
                for(int i = 0; i< adjTable.length; i++)
                {       System.out.print(i + ": ");
                        for(int j = 0; j< adjTable.length; j++)
                        {
                                if(adjTable[i][j] == 1)
                                {
                                        System.out.print(j + " ");
                                }
                        }
                        System.out.println();
                }
        }
        
        private int[] inDegrees()
        {
                int[] answer = new int[vertexCount()];
                
                for(int i = 0; i< adjTable.length; i++)
                {
                        for(int j = 0; j< adjTable.length; j++)
                        {
                                if(adjTable[i][j] == 1)
                                {
                                        answer[j]++; 
                                }
                        }
                }
                return answer;
        }
        
        public int[] topSort()
        {
                int[] temp = inDegrees();
                int[] answer = new int[vertexCount()];
                LQueue q = new LQueue();
                int count = 0;
                
                for(int i = 0; i< temp.length; i++)
                {
                        if(temp[i] == 0)
                        {
                                q.enqueue(i);
                        }
                }
                
                while(!q.isEmpty())
                {
                        int v = (int)q.dequeue();
                        answer[count] = v;
                        count++;
                        for(int j = 0; j< adjTable.length; j++)
                        {
                                
                                if(adjTable[v][j] == 1)
                                {
                                     temp[j]--;    
                                
                                        if(temp[j] == 0)
                                        {
                                                q.enqueue(j);
                                        }
                                }       
                        }
                }
                if(count != vertexCount())
                {
                        throw new RuntimeException();
                }
                return answer;
                
        }
}
