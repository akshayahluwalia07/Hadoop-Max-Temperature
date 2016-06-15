import	java.io.IOException;
import	org.apache.hadoop.io.IntWritable;
import	org.apache.hadoop.io.LongWritable;
import	org.apache.hadoop.io.Text;
import	org.apache.hadoop.mapreduce.Mapper;
public	class	TemperatureMapper
				extends	Mapper<LongWritable,	Text,	Text,	IntWritable>	{
		
		@Override
		public	void	map(LongWritable	key,	Text	value,	Context	context)
						throws	IOException,	InterruptedException	{
			System.out.println("value: " + value);
				String	line	=	value.toString();
				System.out.println("value: " + line);
				String	year	=	line.substring(5,9);
				System.out.println("year: " + year);
				int	airTemperature;
				airTemperature	=	Integer.parseInt(line.substring(9,11));
				context.write(new	Text(year),	new	IntWritable(airTemperature));
				}
		}
