#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
typedef vector<int> vi;
typedef vector<ll> vll;
typedef vector<vi> vvi;
typedef pair<int, int> pii;
typedef vector<pii> vii;
typedef vector<bool> vb;
typedef vector<string> vs;
const int di[] = { -1, 0, 1, 0 };
const int dj[] = { 0, 1, 0, -1 };
const ll MOD = 1e9 + 7;
const ll INF = 1e9;
const double EPS = 1e-6;
#define mp make_pair
#define all(x) x.begin(),x.end()
#define NIL -1

// I AM SURE THERE IS A SMALLER SOLUTION

// A class that represents an undirected graph
class Graph
{
	int V;    // No. of vertices
	list<int> *adj;    // A dynamic array of adjacency lists
	vii bridgeUtil(int v, bool visited[], int disc[], int low[],
		int parent[]);
public:
	Graph(int V);   // Constructor
	void addEdge(int v, int w);   // to add an edge to graph
	vii bridge();    // prints all bridges
};

Graph::Graph(int V)
{
	this->V = V;
	adj = new list<int>[V];
}

void Graph::addEdge(int v, int w)
{
	adj[v].push_back(w);
	adj[w].push_back(v);  // Note: the graph is undirected
}

// A recursive function that finds and prints bridges using
// DFS traversal
// u --> The vertex to be visited next
// visited[] --> keeps tract of visited vertices
// disc[] --> Stores discovery times of visited vertices
// parent[] --> Stores parent vertices in DFS tree
vii Graph::bridgeUtil(int u, bool visited[], int disc[],
	int low[], int parent[])
{
	// A static variable is used for simplicity, we can 
	// avoid use of static variable by passing a pointer.
	static int time = 0;

	// Mark the current node as visited
	visited[u] = true;

	// Initialize discovery time and low value
	disc[u] = low[u] = ++time;

	vii ret;
	// Go through all vertices aadjacent to this
	list<int>::iterator i;
	for (i = adj[u].begin(); i != adj[u].end(); ++i)
	{
		int v = *i;  // v is current adjacent of u

					 // If v is not visited yet, then recur for it
		if (!visited[v])
		{
			parent[v] = u;
			vii tmp = bridgeUtil(v, visited, disc, low, parent);
			ret.insert(ret.end(), all(tmp));

			// Check if the subtree rooted with v has a 
			// connection to one of the ancestors of u
			low[u] = min(low[u], low[v]);

			// If the lowest vertex reachable from subtree 
			// under v is  below u in DFS tree, then u-v 
			// is a bridge
			if (low[v] > disc[u])
				ret.push_back({ u,v });
			//cout << u << " " << v << endl;
		}

		// Update low value of u for parent function calls.
		else if (v != parent[u])
			low[u] = min(low[u], disc[v]);
	}

	return ret;
}

// DFS based function to find all bridges. It uses recursive 
// function bridgeUtil()
vii Graph::bridge()
{
	// Mark all the vertices as not visited
	bool *visited = new bool[V];
	int *disc = new int[V];
	int *low = new int[V];
	int *parent = new int[V];

	// Initialize parent and visited arrays
	for (int i = 0; i < V; i++)
	{
		parent[i] = NIL;
		visited[i] = false;
	}

	vii ret;
	// Call the recursive helper function to find Bridges
	// in DFS tree rooted with vertex 'i'
	for (int i = 0; i < V; i++)
		if (visited[i] == false) {
			vii tmp = bridgeUtil(i, visited, disc, low, parent);
			ret.insert(ret.end(), all(tmp));
		}
	return ret;
}

int n, m;
vector<vii> adj;
map<pii, int> idx;
vi rs;

struct Edge {
	int u, v, w;

	bool operator > (const Edge other) const {
		return w < other.w;
	}
};

int find(vector<int> &C, int x) { return (C[x] == x) ? x : C[x] = find(C, C[x]); }
void merge(vector<int> &C, int x, int y) { C[find(C, x)] = find(C, y); }

inline void any(pii x) {
	rs[idx[x]] = 1;
}

inline void none(pii x) {
	rs[idx[x]] = -1;
}

// ALL THE MAGIC HAPPENS HERE
void MST() {
	vector< pair<int, pii> > EdgeList; // (weight, two vertices)
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < adj[i].size(); j++) {
			int u = i;
			int v = adj[i][j].first;
			int w = adj[i][j].second;
			EdgeList.push_back(make_pair(w, pii(u, v)));
		}
	}
	sort(EdgeList.rbegin(), EdgeList.rend());

	vector<int> C(n);
	for (int i = 0; i < n; i++) C[i] = i;

	while (!EdgeList.empty()) {
		int cw = EdgeList.back().first;
		vector<pair<int, pii>> cn;

		while (!EdgeList.empty() && EdgeList.back().first == cw)
			cn.push_back(EdgeList.back()), EdgeList.pop_back();

		set<int> st;
		for (int i = 0; i < cn.size(); i++) {
			st.insert(find(C, cn[i].second.first));
			st.insert(find(C, cn[i].second.second));
		}
		map<int, int> comp; int c = 0;
		for (auto& i : st) comp[i] = c++;

		Graph g(c);
		map<pii, pii> tmpIdx; // change (comp, comp) back to (node, node)
		set<pii> maybe;

		for (int i = 0; i < cn.size(); i++) {
			pair<int, pii> cur = cn[i];
			int comp1 = comp[find(C, cur.second.first)];
			int comp2 = comp[find(C, cur.second.second)];

			if (comp1 == comp2) none(cur.second);
			else {
				if (tmpIdx.find({ comp1,comp2 }) != tmpIdx.end()) {
					maybe.insert({ comp1,comp2 });
					maybe.insert({ comp2,comp1 });
					continue;
				}

				g.addEdge(comp1, comp2);
				tmpIdx[{comp1, comp2}] = cur.second;
				tmpIdx[{comp2, comp1}] = cur.second;
			}
		}

		vii bridges = g.bridge();
		for (auto& i : bridges)
			if (maybe.find(i) == maybe.end())
				any(tmpIdx[i]);

		// Actually connect the components
		for (int i = 0; i < cn.size(); i++) {
			pair<int, pii> cur = cn[i];
			if (find(C, cur.second.first) != find(C, cur.second.second))
				merge(C, cur.second.first, cur.second.second);
		}
	}
}

int main() {
	ios::sync_with_stdio(false), cin.tie(0);
	cin >> n >> m;
	adj.assign(n, vii());
	rs.assign(m, 0);

	for (int i = 0; i < m; i++) {
		int u, v, w; cin >> u >> v >> w; u--, v--;
		idx[{u, v}] = idx[{v, u}] = i;
		adj[u].push_back({ v,w });
		//adj[v].push_back({ u,w });
	}

	MST();
	for (int i = 0; i < m; i++) {
		if (rs[i] == -1)
			cout << "none\n";
		else if (rs[i] == 0)
			cout << "at least one\n";
		else
			cout << "any\n";
	}
	cin.ignore(), cin.get();
}
