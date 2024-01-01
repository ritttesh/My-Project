@RunWith(Cucumber.class)
@Cucumberoptions(feature= {"src\\feature\\feature1.feature"},glue= {"src\\glue\\Glue1.java"}
		plugin= {"html:hrepo.html","json:jsrepo.json","junit:jrepo.xml"})
public class RunnerClass1 {

}
