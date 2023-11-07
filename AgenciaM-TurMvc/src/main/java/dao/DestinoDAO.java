package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import model.Destino;

public class DestinoDAO {
	// adicionar
	public void cadastrar(Destino destino) {
		String sql = "INSERT INTO destino (Nome_Destino, Preco_Destino, imagem) " + "VALUES (?, ?, ?)";
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = Conexao.createConnectionToMySql();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, destino.getNomeDestino());
			pstm.setDouble(2, destino.getPrecoDestino());
			byte[] imagemByte = destino.getImagem();
			pstm.setBytes(3, imagemByte);

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

	public List<Destino> getDestino() {
		String sql = "SELECT * FROM destino";
		List<Destino> destino = new ArrayList<Destino>();
		Connection conn = null;
		PreparedStatement pstm = null;
		// classe que vai recuperar os dados do banco de dados
		ResultSet rset = null;
		try {
			conn = Conexao.createConnectionToMySql();
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();
			// enquanto existir dados no banco de dados faça
			while (rset.next()) {
				Destino destin = new Destino();

				destin.setId(rset.getInt("Id_Destino"));
				destin.setNomeDestino(rset.getString("Nome_Destino"));
				destin.setPrecoDestino(rset.getFloat("Preco_Destino"));
				destino.add(destin);
			}
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
		return destino;
	}

	public void atualizar(Destino destino) {
		String sql = "UPDATE destino SET Nome_Destino = ?, Preco_Destino = ?, imagem = ?" + "WHERE Id_Destino = ?";
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = Conexao.createConnectionToMySql();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, destino.getNomeDestino());
			pstm.setDouble(2, destino.getPrecoDestino());
			pstm.setBytes(3, destino.getImagem());
			pstm.setInt(4, destino.getId());
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

	// exluir
	public void removerById(int idDestino) {
		String sql = "DELETE FROM destino WHERE Id_Destino = ?";
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = Conexao.createConnectionToMySql();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, idDestino);
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

	public Destino consultarById(int idDestino) {
		Destino destino = new Destino();
		String sql = "SELECT * FROM destino WHERE Id_Destino = ?";

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		try {
			conn = Conexao.createConnectionToMySql();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, idDestino);

			rset = pstm.executeQuery();
			rset.next();

			destino.setId(rset.getInt("Id_Destino"));
			destino.setNomeDestino(rset.getString("Nome_Destino"));
			destino.setPrecoDestino(rset.getFloat("Preco_Destino"));
			destino.setImagem(rset.getBytes("imagem"));

		} catch (

		Exception e) {
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
		return destino;
	}
	
	public Destino consultarImagemById(int idDestino) {
	    Destino destino = new Destino();
	    String sql = "SELECT imagem FROM destino WHERE Id_Destino = ?";

	    Connection conn = null;
	    PreparedStatement pstm = null;
	    ResultSet rset = null;
	    try {
	        conn = Conexao.createConnectionToMySql();
	        pstm = conn.prepareStatement(sql);
	        pstm.setInt(1, idDestino);

	        rset = pstm.executeQuery();
	        if (rset.next()) {
	            destino.setImagem(rset.getBytes("imagem"));
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
	    return destino;
	}

}
