import React, {useState} from 'react'; 
function UploadForm({onResult}){
    const [file, setFile ] = useState(null); // null means init value of setfile
    const [width, setWidth] = useState(29);
    const [ height, setHeight] = useState(29); 

    const handleSubmit = async(e)=>{
        e.preventDefault(); 
        const formData = new FormData(); 
        formData.append('file', file);
        formData.append('width', width);
        formData.append('height', height); 
        const res = await fetch('http://localhost:8080/api/template/upload',{
            method:'POST',
            body: formData,
        }); 

        const data = await res.json(); 
        onResult(data); //pass grid to parent , onResult is the prop passed to uploadForm

    };


    return (
    <form onSubmit={handleSubmit}>
      <input type="file" accept="image/*" onChange={(e) => setFile(e.target.files[0])} required />
      <input type="number" value={width} onChange={(e) => setWidth(e.target.value)} min="1" max="60" />
      <input type="number" value={height} onChange={(e) => setHeight(e.target.value)} min="1" max="60" />
      <button type="submit">Generate Bead Template</button>
    </form>
    );
}


export default UploadForm; 