 public static string No_SqlHack(string inputStr)
        {
            //Ҫ���˵ùؼ���
            string NoSqlHack_AllStr = "|;|and|chr(|exec|insert|select|delete|from|update|mid(|master.|";
            string SqlHackGet = inputStr;
            string[] AllStr = NoSqlHack_AllStr.Split('|');

            //�ı�����������ַ������ÿո�ָ���
            string[] GetStr = SqlHackGet.Split(' ');
            if (SqlHackGet != "")
            {
                for (int j = 0; j < GetStr.Length; j++)
                {
                    for (int i = 0; i < AllStr.Length; i++)
                    {
                        if (GetStr[j].ToLower() == AllStr[i].ToLower())
                        {
                            GetStr[j] = "";
                            
                            break;
                        }
                    }
                }
                StringBuilder sbSafeString = new StringBuilder();
                for (int i = 0; i < GetStr.Length; i++)
                {
                    sbSafeString.Append(GetStr[i].ToString() + " ");
                }
                return sbSafeString.ToString().TrimEnd(' ').Replace("'", "\"").Replace("<", "&lt;");
            }
            else
            {
                return "";
            }
        }        