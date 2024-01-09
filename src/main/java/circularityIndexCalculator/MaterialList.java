package circularityIndexCalculator;

import productsystem.AggregatedProcess;
import productsystem.Process;
import productsystem.UnitaryProcess;

import java.util.ArrayList;
import java.util.List;

public class MaterialList {
    List<Material> list;
    Process process;

    public MaterialList(Process process) {
        this.process=process;
        this.list=new ArrayList<>();
    }

    private List<String> getMaterialName(Process p ) {
        if (p == null) {
            throw new IllegalArgumentException("Process cannot be null");
        }
        List<String> names = new ArrayList<>();
        if (p instanceof UnitaryProcess) {
            for (int i = 0; i < ((UnitaryProcess) p).getInput().size(); i++) {
                if (((UnitaryProcess) p).getInput().get(i).getCategory().contains("Materials") || ((UnitaryProcess) p).getInput().get(i).getCategory().contains("Recurso")) {
                    names.add(((UnitaryProcess) p).getInput().get(i).getFlowName());
                }
            }
        }
        return names;
    }
    private double getVirginMaterial(String name,Process p){
        if(name==null){
            throw new IllegalArgumentException("Name cannot be null");
        }
        if(p==null){
            throw new IllegalArgumentException("Process cannot be null");
        }
        for(int i=0;i<((UnitaryProcess)p).getInput().size();i++){
            if(((UnitaryProcess) p).getInput().get(i).getFlowName().equals(name) && ((UnitaryProcess) p).getOutput().get(i).getFlowName().equals("Material Virgem(V)")){
                return ((UnitaryProcess) p).getOutput().get(i).getQuantity();
            }
        }
        return 0;
    }
    private double getRecoveredMaterial(String name,Process p){
        if(name==null){
            throw new IllegalArgumentException("Name cannot be null");
        }
        if(p==null){
            throw new IllegalArgumentException("Process cannot be null");
        }
        for(int i=0;i<((UnitaryProcess)p).getInput().size();i++){
            if(((UnitaryProcess) p).getInput().get(i).getFlowName().equals(name) && ((UnitaryProcess) p).getOutput().get(i).getFlowName().equals("Materiais recuperados EoL (Rr)")){
                return ((UnitaryProcess) p).getOutput().get(i).getQuantity();
            }
        }
        return 0;
    }
    private double getRecycledWaste(String name,Process p){
        if(name==null){
            throw new IllegalArgumentException("Name cannot be null");
        }
        if(p==null){
            throw new IllegalArgumentException("Process cannot be null");
        }
        for(int i=0;i<((UnitaryProcess)p).getInput().size();i++){
            if(((UnitaryProcess) p).getInput().get(i).getFlowName().equals(name) && ((UnitaryProcess) p).getOutput().get(i).getFlowName().equals("Waste produzido na reciclagem (Wc)")){
                return ((UnitaryProcess) p).getOutput().get(i).getQuantity();
            }
        }
        return 0;
    }
    private double getRadioactiveWaste(String name,Process p){
        if(name==null){
            throw new IllegalArgumentException("Name cannot be null");
        }
        if(p==null){
            throw new IllegalArgumentException("Process cannot be null");
        }
        for(int i=0;i<((UnitaryProcess)p).getInput().size();i++){
            if(((UnitaryProcess) p).getInput().get(i).getFlowName().equals(name) && ((UnitaryProcess) p).getOutput().get(i).getFlowName().equals("Waste radioactivo (Wr)")){
                return ((UnitaryProcess) p).getOutput().get(i).getQuantity();
            }
        }
        return 0;
    }
    private double getRecycledMaterial(String name,Process p){
        if(name==null){
            throw new IllegalArgumentException("Name cannot be null");
        }
        if(p==null){
            throw new IllegalArgumentException("Process cannot be null");
        }
        for(int i=0;i<((UnitaryProcess)p).getInput().size();i++){
            if(((UnitaryProcess) p).getInput().get(i).getFlowName().equals(name) && ((UnitaryProcess) p).getOutput().get(i).getFlowName().equals("Materiais reciclados (R) (+ Burden Free) (-cr)")){
                return ((UnitaryProcess) p).getOutput().get(i).getQuantity();
            }
        }
        return 0;
    }
    private double getMainEnergy(String name,Process p){
        if(name==null){
            throw new IllegalArgumentException("Name cannot be null");
        }
        if(p==null){
            throw new IllegalArgumentException("Process cannot be null");
        }
        for(int i=0;i<((UnitaryProcess)p).getInput().size();i++){
            if(((UnitaryProcess) p).getInput().get(i).getFlowName().equals(name) && ((UnitaryProcess) p).getOutput().get(i).getFlowName().equals("Energia necessária para produção das matérias/produtos principais")){
                return ((UnitaryProcess) p).getOutput().get(i).getQuantity();
            }
        }
        return 0;
    }
    private double getSecondaryEnergy(String name,Process p){
        if(name==null){
            throw new IllegalArgumentException("Name cannot be null");
        }
        if(p==null){
            throw new IllegalArgumentException("Process cannot be null");
        }
        for(int i=0;i<((UnitaryProcess)p).getInput().size();i++){
            if(((UnitaryProcess) p).getInput().get(i).getFlowName().equals(name) && ((UnitaryProcess) p).getOutput().get(i).getFlowName().equals("Energia necessária para produção das matérias/produtos secundário")){
                return ((UnitaryProcess) p).getOutput().get(i).getQuantity();
            }
        }
        return 0;
    }
    private double getWasteProduction(String name,Process p){
        if(name==null){
            throw new IllegalArgumentException("Name cannot be null");
        }
        if(p==null){
            throw new IllegalArgumentException("Process cannot be null");
        }
        for(int i=0;i<((UnitaryProcess)p).getInput().size();i++){
            if(((UnitaryProcess) p).getInput().get(i).getFlowName().equals(name) && ((UnitaryProcess) p).getOutput().get(i).getFlowName().equals("Waste na produção de materiais (Wf) - ws")){
                return ((UnitaryProcess) p).getOutput().get(i).getQuantity();
            }
        }
        return 0;
    }
    private Material createMaterial(String name,Process p){
        if(name == null){
            throw new IllegalArgumentException("Name cannot be null");
        }
        if(p == null){
            throw new IllegalArgumentException("Process cannot be null");
        }

        Material material = new Material(name);
        material.setVirginMaterial(getVirginMaterial(name,p));
        material.setRecoveredMaterial(getRecoveredMaterial(name,p));
        material.setWasteRadioactive(getRadioactiveWaste(name,p));
        material.setRecycledMaterial(getRecycledMaterial(name,p));
        material.setEnergyNeededForMainMaterial(getMainEnergy(name,p));
        material.setEnergyNeededForSecondaryMaterial(getSecondaryEnergy(name,p));
        material.setWasteProduction(getWasteProduction(name,p));
        material.setRecycledMaterial(getRecycledMaterial(name,p));
        material.setWasteOnRecycling(getRecycledWaste(name,p));
        return material;

    }
    private void createAllMaterial(Process p){
        if(p == null){
            throw new IllegalArgumentException("Process cannot be null");
        }
        if(p instanceof UnitaryProcess){
            for (String s:getMaterialName(p)){
                this.list.add(createMaterial(s,p));
            }
        }else if(p instanceof AggregatedProcess){
            for(UnitaryProcess un:((AggregatedProcess) p).getContainer()){
                for (String s:getMaterialName(un)){
                    this.list.add(createMaterial(s,un));
                }
            }
        }
    }
    public List<Material> getMaterials(){
        createAllMaterial(this.process);
        return this.list;
    }





}
