package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import connection.connection;
import model.Destino;



public class DestinoDao {

	Connection conn = null;
	PreparedStatement pstm = null;

	// Salvar usuario
	public void saveUser(Destino destino) {
		
		String sql = "INSERT INTO destino(nome, email, telefone, destino, aerea, preco)" + "VALUES(?, ?, ?, ?, ?, ?);";

		try {
			conn = connection.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);

			pstm.setString(1, destino.getNome());
			pstm.setString(2, destino.getEmail());
			pstm.setInt(3, destino.getTelefone());
			pstm.setString(4, destino.getDestino());
			pstm.setString(5, destino.getAerea());
			pstm.setInt(6, destino.getPreco());
			pstm.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {

					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {

				e.printStackTrace();
			}
		}
	}

	// Metodo para Ler
		public List<Destino> readUsers() {
			String sql = "select * from destino;";

			List<Destino> Destino = new ArrayList<Destino>();

			// Classe que vai recuperar os dados do banco de dados
			ResultSet rset = null;

			try {
				conn = connection.createConnectionMySQL();

				pstm = conn.prepareStatement(sql);

				rset = pstm.executeQuery();

				while (rset.next()) {
					Destino destino = new Destino();

					destino.setId(rset.getInt("id"));

					destino.setNome(rset.getString("nome"));

					destino.setEmail(rset.getString("email"));

					destino.setTelefone(rset.getInt("telefone"));
					
					destino.setDestino(rset.getString("destino"));

					destino.setAerea(rset.getString("aerea"));
					
					destino.setId(rset.getInt("preco"));

					Destino.add(destino);

				}

			} catch (Exception e) {
				e.printStackTrace();

			} finally {
				try {
					if (rset != null) {
						rset.close();
					}
					if (pstm != null) {
						pstm.close();
					}
					if (conn != null) {
						conn.close();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			return Destino;
		}

	// Atualizar dados do usuario
	public void updateUser(Destino destino) {
		String sql = "UPDATE destino SET nome = ?, telefone = ?, destino = ?, email = ?, aerea = ?, preco = ?" + " WHERE id = ?";

		try {
			conn = connection.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, destino.getNome());
			pstm.setInt(2, destino.getTelefone());
			pstm.setString(3, destino.getDestino());
			pstm.setString(4, destino.getEmail());
			pstm.setString(5, destino.getAerea());
			pstm.setInt(6, destino.getPreco());
			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {

					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {

				e.printStackTrace();
			}

		}
	}

	//Deletar usuario
	public void deleteUser(int id) {
		String sql = "DELETE FROM destino" + " WHERE id = ?";

		try {
			conn = connection.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {

					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	
	
	
	public Destino getUserById(int id) {
		Destino destino = new Destino();
		String sql = "SELECT * FROM destino WHERE id = ? ;";
		
		ResultSet rset = null;

		try {
			conn = connection.createConnectionMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			
			rset = pstm.executeQuery();

			rset.next();
			
			destino.setId(rset.getInt("id"));
			
			destino.setNome(rset.getString("nome"));
			
			destino.setEmail(rset.getString("email"));

			destino.setTelefone(rset.getInt("telefone"));
			
			destino.setDestino(rset.getString("destino"));

			destino.setAerea(rset.getString("aerea"));
			
			destino.setId(rset.getInt("preco"));
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rset != null) {
					rset.close();
				}
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return destino;
	}

}
