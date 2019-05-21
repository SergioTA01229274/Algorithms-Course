public class ChickenLittle {
	int[][] matrix;
	final static boolean DOWN=true;
	final static boolean RIGHT=false;
	
	public ChickenLittle(int[][] matrix){
		int rows=matrix[0].length;
		for(int[] x:matrix){
			if(x.length!=rows){
				System.out.println("Non regular matrix");
				break;
			}
		}
		this.matrix=matrix;
		this.matrix[this.matrix.length-1][this.matrix[this.matrix.length-1].length-1]=-2;
	}
	private int peek(int x,int y, boolean direction){
		if(ChickenLittle.DOWN==direction){
			try{
				int access=matrix[x][y+1];
				return access;
			}catch(IndexOutOfBoundsException e){
				return -1;
			}
		}
		else{
			try{
				int access=matrix[x+1][y];
				return access;
			}catch(IndexOutOfBoundsException e){
				return -1;
			}
		}
		
	}
	
	public int recursive(int px, int py){//volteados
		int h= this.peek(px, py, RIGHT);
		int v= this.peek(px, py, DOWN);
		if(v==-2 || h==-2){
			matrix[px][py]=1;
			return 1;
		}
		else{
			if(h==-1 && v==-1){
				return 0;
			}
			else if(h==-1 && v!=-1){
				if(v>0){
					matrix[px][py]=v;
				}else{
					matrix[px][py]=recursive(px,py+1);
				}
			}
			else if(h!=-1 && v==-1){
				if(h>0){
					matrix[px][py]=h;
				}else{
					matrix[px][py]=recursive(px+1,py);
				}
			}
			else{
				if(h>0 && v>0){
					matrix[px][py]=h+v;
				}
				else if(h>0){
					matrix[px][py]=recursive(px,py+1)+h;
				}
				else if(v>0){
					matrix[px][py]=recursive(px+1,py)+v;
				}
				else{
					matrix[px][py]=recursive(px+1,py) + recursive(px,py+1);

				}
			}
			return matrix[px][py];
		}
	}
	
	public static void main(String[] args){
		int[][] Maze= new int[][]{{0,0,0,0,0,-1,0},{0,0,0,0,0,0,0},{0,-1,0,-1,0,0,0},{0,0,-1,0,0,0,0},{0,0,0,0,0,-1,0},{0,0,0,0,0,0,0}};
		ChickenLittle pollito= new ChickenLittle(Maze);
		System.out.println("Total Paths: " + pollito.recursive(0, 0));
		System.out.println();
		System.out.println("Resultant Maze: ");
		System.out.println();
		for(int[] x:Maze){
			for(int y:x){
				System.out.print(y+",");
			}
			System.out.println("");
		}
	}
}