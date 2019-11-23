
//Board Table
create table t_board(
  board_idx INT,
  title VARCHAR2(300),
  contents VARCHAR2(300),
  hit_cnt INT,
  created_datetime DATE,
  creator_id VARCHAR2(50),
  updated_datetime DATE,
  updater_id VARCHAR2(50),
  deleted_yn CHAR(1),
  CONSTRAINT pk PRIMARY KEY(board_idx)
);


			SELECT 
				board_idx,
				title,
				hit_cnt,
				created_datetime
			FROM
				t_board
			WHERE
				deleted_yn != 'Y'	
			ORDER BY board_idx DESC
      
      
      
// mybatis

			INSERT INTO t_board
			(
				board_idx,
				title,
				contents,
				created_datetime,
				creator_id
			)
			VALUES
			(
				seq_board.nextval,
				#{title},
				#{contents},
				sysdate,
				'admin'
			)



			UPDATE t_board SET
				title = #{title},
				contents = #{contents},
				updated_datetime = sysdate,
				updater_id = 'admin'
			WHERE
				board_idx = #{boardIdx}
        
        
        
			UPDATE t_board SET
				deleted_yn = 'Y',
				updated_datetime = sysdate,
				updater_id = 'admin'
			WHERE
				board_idx = #{boardIdx}
        
        
        


//Upload File Table
create table t_file(
  idx INT,
  board_idx INT,
  original_file_name VARCHAR2(300),
  stored_file_path VARCHAR2(500),
  file_size INT,
  creator_id VARCHAR2(300),
  created_datetime DATE,
  updator_id VARCHAR2(50),
  updated_datetime DATE,
  deleted_yn CHAR(1) DEFAULT 'N',
  CONSTRAINT file_pk PRIMARY KEY(idx)
);

 

