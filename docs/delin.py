import sys
import pyvips
#import logging     
#logging.basicConfig(level = logging.DEBUG)
#                      
# threshold ... why not

   
T = float(sys.argv[3])
ps = pyvips.Image.new_from_file(sys.argv[1], access='sequential')
# window size (neighbourhood) we search over
window_size = 3  #sys.argv[4]  

def delin(T,ps,windows_size):
           
    # find the max and min for each window
    ps_min = ps.rank(window_size, window_size, 0)
    ps_max = ps.rank(window_size, window_size, window_size * window_size - 1)
  
    # difference   
    D = ps_max - ps_min

    # for border pixels,
    border = (ps - ps_min < ps_max - ps).ifthenelse(ps_min, ps_max)
  
    out_ps = (D < T).ifthenelse(ps, border)
    
      

    return out_ps.write_to_file(sys.argv[2])
    
    
    
    
