//判断是否存在sql攻击
//input 用户提交的数据
//true-存在攻击规则 false-没有攻击规则
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