//�ж��Ƿ����sql����
//input �û��ύ������
//true-���ڹ������� false-û�й�������
public bool CheckSqlHacker(string inputStr)
{
            string SqlStr = @"and|or|exec|execute|insert|select|delete|update|alter|create|drop|count|\*|chr|char|asc|mid|substring|master|truncate|declare|xp_cmdshell|restore|backup|net +user|net +localgroup +administrators";
            try
            {
                if (inputStr != null && inputStr != string.Empty)
                {
                    string str_Regex = @"\b(" + SqlStr + @")\b";
                    Regex regex = new Regex(str_Regex, RegexOptions.IgnoreCase);
                    if (regex.IsMatch(inputStr))
                    {
                        return true;                     
                    }
                }
            }
            catch
            {
                return true;
            }
            
            return false;
}