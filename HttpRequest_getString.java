 try
 {
 // Defined URL  where to send data
 URL url = new URL(request.getUrl());
 // Send POST data request
 HttpURLConnection conn = (HttpURLConnection)url.openConnection();
 conn.setRequestMethod(request.getMethod());
 if(request.getContent()!=null &&  request.getContent().length()>0) {
 conn.setDoOutput(true);
 conn.setRequestProperty("Content-Type","application/json");
 conn.setRequestProperty("Accept-Type","application/json");
 conn.setRequestProperty("Content-Length", "" + request.getContent().length());
 OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
 wr.write(request.getContent());
 wr.flush();
 }
//1 conn.setUseCaches(false);
 // Get the server response
 reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
 StringBuilder sb = new StringBuilder();
 String line = null;
 // Read Server Response
 while((line = reader.readLine()) != null)
 {
 // Append server response in string
 sb.append(line + "");
 }
// Append Server Response To Content String
 // Content = sb.toString();
 return sb.toString();
 }
