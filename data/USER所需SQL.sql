-- 序列：id自增
create sequence id_seq
increment by 1
START WITH 1
nomaxvalue
nominvalue
nocycle
nocache



-- 插入用户
insert into "user" values(id_seq.nextval, '1002',FN_MD5('1002'))


-- MD5函数
CREATE OR REPLACE FUNCTION fn_md5(input_string IN VARCHAR2)
    RETURN VARCHAR2
IS
    raw_input RAW (128) := UTL_RAW.cast_to_raw (input_string);
    decrypted_raw RAW (2048);
    error_in_input_buffer_length     
EXCEPTION;
BEGIN
    DBMS_OBFUSCATION_TOOLKIT.md5(input => raw_input,
		checksum => decrypted_raw);
    RETURN UPPER(RAWTOHEX (decrypted_raw));
END;

-- 更新密码为MD5加密密码
update  "user" set "password" = FN_MD5("password");

