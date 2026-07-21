package com.ssafy.ws.step3;

/**
 * B구획의 빌딩 최고 높이 구하기
 */ 
public class BuildingTest {
	public static int[][] d8 = {{-1,0},{1,0},{0,-1},{0,1},{-1,-1},{1,1},{-1,1},{1,-1}};
	public static int[][] d4 = {{-1,0},{1,0},{0,-1},{0,1}};

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		StringBuilder sb = new StringBuilder();
		
		for(int test_case=1;test_case<=T;test_case++) {
			//입력
			int n = Integer.parseInt(br.readLine().trim());
			char[][] map = new char[n][n];
			for(int i=0;i<n;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine().trim());
				for(int j=0;j<n;j++) {
					map[i][j] = st.nextToken().charAt(0);
				}
			}
			int maxV = 0;
			//탐색
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					boolean green = false;
					//G체크
					for(int[] d:d8) {
						int ni=i+d[0];
						int nj=j+d[0];
						if(ni<0||nj<0||ni>=n||nj>=n)
							continue;
						if(map[ni][nj]=='G') {
							green=true;
							break;
						}
					}
					//G별로 처리
					int bNum=2;
					if(green==false){
						bNum = 1;
						for(int[] d:d4) {
							for(int b=1;!(i+d[0]*b<0||j+d[1]*b<0||i+d[0]*b>=n||j+d[1]*b>=n); b++) {
								int ni = i+d[0]*b;
								int nj = j+d[1]*b;
								if(map[ni][nj]=='G')
									break;
								else {
									bNum+=1;
								}
							}
						}
					}
					maxV = Math.max(maxV,bNum);
				}
			}
			sb.append("#").append(test_case).append(" ").append(maxV).append("\n");
		}
		System.out.println(sb);
	}
}
